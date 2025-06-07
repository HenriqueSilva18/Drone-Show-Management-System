package lapr4.app.customer.console.http;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HTTPmessage {

    private static final int CR = 13;
    private static final int LF = 10;

    private static final String VERSION = "HTTP/1.1";
    private static final String CONTENT_TYPE = "Content-Type:";
    private static final String CONTENT_LENGTH = "Content-Length:";
    private static final String CONNECTION = "Connection:";

    private static final String[][] knownFileExt = {
            { ".pdf", "application/pdf" }, { ".js", "application/javascript" },
            { ".txt", "text/plain" }, { ".gif", "image/gif" },
            { ".png", "image/png" }, { ".html", "text/html" }
    };

    private List<String> header;
    private byte[] content;
    private String method;
    private String uri;
    private String status;
    private String contentType;

    public HTTPmessage() {
        header = new ArrayList<>();
        content = null; method = null; uri = null; status = null; contentType = null;
    }

    public HTTPmessage(DataInputStream in) throws IOException {
        this();
        String firstLine = readHeaderLine(in);
        if (firstLine == null || firstLine.isEmpty()) {
            throw new IOException("Invalid or empty HTTP message.");
        }

        if (firstLine.startsWith("HTTP/")) {
            String[] parts = firstLine.split(" ", 3);
            if (parts.length >= 2) {
                this.status = parts[1] + (parts.length > 2 ? " " + parts[2] : "");
            }
        } else {
            String[] parts = firstLine.split(" ");
            if (parts.length >= 2) {
                this.method = parts[0];
                this.uri = parts[1];
            }
        }

        String h;
        do {
            h = readHeaderLine(in);
            if (h != null && !h.isEmpty()) {
                header.add(h);
                if (h.toLowerCase().startsWith(CONTENT_LENGTH.toLowerCase())) {
                    try {
                        int len = Integer.parseInt(h.substring(CONTENT_LENGTH.length()).trim());
                        content = new byte[len];
                    } catch (NumberFormatException e) {
                        throw new IOException("Invalid Content-Length value.");
                    }
                }
            }
        } while (h != null && !h.isEmpty());

        if (content != null) {
            in.readFully(content, 0, content.length);
        }
    }

    public void setResponseStatus(String s) {
        status = s;
    }

    public String getStatus() {
        return status;
    }

    public void setRequestMethod(String m) {
        method = m;
    }

    public String getMethod() {
        return method;
    }

    public void setURI(String u) {
        uri = u;
    }

    public String getURI() {
        return uri;
    }

    public void send(DataOutputStream out) throws IOException {
        if (method != null) { // It's a request
            writeHeaderLine(out, method + " " + uri + " " + VERSION);
        } else if (status != null) { // It's a response
            writeHeaderLine(out, VERSION + " " + status);
        }

        if (content != null) {
            writeHeaderLine(out, CONTENT_TYPE + " " + contentType);
            writeHeaderLine(out, CONTENT_LENGTH + " " + content.length);
        }

        writeHeaderLine(out, CONNECTION + " close");
        writeHeaderLine(out, "");

        if (content != null) {
            out.write(content, 0, content.length);
        }
    }

    public boolean hasContent() {
        return (content != null);
    }

    public String getContentAsString() {
        if (content == null) return null;
        return new String(content);
    }

    public byte[] getContent() {
        return content;
    }

    public void setContentFromString(String c, String ct) {
        content = c.getBytes();
        contentType = ct;
    }

    public boolean setContentFromFile(String fname) {
        File f = new File(fname);
        if (!f.exists() || !f.isFile()) {
            return false;
        }

        contentType = "application/octet-stream"; // Default MIME type
        for (String[] k : knownFileExt) {
            if (fname.toLowerCase().endsWith(k[0])) {
                contentType = k[1];
                break;
            }
        }

        try (DataInputStream fr = new DataInputStream(new FileInputStream(f))) {
            content = new byte[(int)f.length()];
            fr.readFully(content);
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
            return false;
        }
        return true;
    }

    private static String readHeaderLine(DataInputStream in) throws IOException {
        StringBuilder ret = new StringBuilder();
        int val;
        do {
            val = in.read();
            if (val == -1) return null; // End of stream
            if (val != CR) ret.append((char) val);
        } while (val != CR);
        in.read(); // read LF
        return ret.toString();
    }

    private static void writeHeaderLine(DataOutputStream out, String line) throws IOException {
        out.writeBytes(line);
        out.write(CR);
        out.write(LF);
    }
}