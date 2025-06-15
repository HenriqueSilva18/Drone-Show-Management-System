# US372 - Check Shows Dates

## 1. Context

This README covers the implementation of user story US372 for listing scheduled shows for customers in the system.

### 1.1 List of issues

* US372 Issues: [GitHub issues link](https://github.com/orgs/Departamento-de-Engenharia-Informatica/projects/1100/views/1?pane=issue&itemId=111563987&issue=Departamento-de-Engenharia-Informatica%7Csem4pi-2024-2025-sem4pi_2024_2025_g39%7C344)

## 2. Requirements

### US372 - Check Shows Dates

As a Customer, I want to list my scheduled shows.

**Acceptance Criteria:**
- Display all scheduled shows for the authenticated customer
- Show relevant information for each scheduled show (date, time, location, status)
- Only show future/upcoming shows (not past shows)
- Provide proper filtering and ordering of results

## 3. Analysis

### 3.1 Business Rules

* **Authorization Rules:**
    * Customer representatives access shows through username parameter
    * Shows filtered by customer association via REPRESENTATIVE table join
    * Database query joins SHOW_PROPOSAL with REPRESENTATIVE using CUSTOMER_VAT
    * No direct role verification in this endpoint (handled by authentication layer)

* **Show Listing Rules:**
    * Only shows with STATUS = 'SCHEDULED' are returned
    * Shows are filtered by customer through REPRESENTATIVE.SYSTEMUSER_USERNAME
    * Response includes: Show ID (NUMBER), DateTime (EVENTDATETIME), Location (LATITUDE/LONGITUDE)
    * DateTime returned in ISO format for JavaScript compatibility
    * Empty JSON array returned when no scheduled shows found
    * Database connection uses prepared statements for SQL injection prevention

## 4. Design

### 4.1 Architecture

* Client-Server Architecture:
    * Customer App (Client):
        * Web-based frontend using HTML, CSS, and JavaScript
        * Communicates with Customer App Server via HTTP
        * No direct database access
        * Handles user interface and client-side filtering/sorting
    * Customer App Server:
        * Java-based HTTP server using Berkeley Sockets API
        * Implements HTTP protocol over TCP
        * Handles client requests and database operations
        * Manages authentication and authorization
    * Database:
        * H2 Database accessed only by Customer App Server
        * Stores show proposals, customer data, and scheduling information


* **Communication Protocol:**
    * HTTP over TCP sockets (Berkeley Sockets API)
    * Stateless request-response model
    * **Main Endpoint:** GET /shows/scheduled?user={username}
    * Request validation: 400 Bad Request if 'user' parameter missing
    * Response: JSON array with 200 OK status
    * Database: H2 at `jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10860/databaseName`
    * Connection pooling: New connection per request (try-with-resources)


* Component Interaction:
    * Customer App → Customer App Server:
        * HTTP requests for scheduled shows list
        * Authentication requests
        * Optional filtering parameters
    * Customer App Server → Database:
        * SQL queries for scheduled shows
        * User authentication verification
        * Customer association validation
        * Date filtering and ordering

## 5. Implementation

### Core Components

* Server Components:
    * `CustomerAppHttpServer.java`:
        * Main HTTP server implementation using ServerSocket
        * H2 Database driver initialization
        * Thread-per-connection model (accepts connections and spawns CustomerAppRequest threads)
        * Configurable port via command line argument
    * `CustomerAppRequest.java`:
        * HTTP request processing thread
        * **handleScheduledShows()** method - core logic for US372
        * **getScheduledShowsForUser()** method - database query execution
        * Parameter validation and error handling
        * JSON response formatting
    * `HTTPmessage.java`:
        * HTTP protocol implementation
        * Request parsing and response formatting
        * Content-Type handling for JSON responses


* Client Components:
    * `dashboard.html`:
        * Main application interface
        * Scheduled shows list display
        * Date filtering options
        * Show selection interface
    * `dashboard.js`:
        * HTTP client implementation
        * Scheduled shows fetching
        * List rendering and updates
        * Date filtering functionality
        * Error handling and user feedback
    * `auth.js`:
        * Authentication handling
        * Session management
        * User role verification

### 5.1 Key Implementation Details

* **Database Configuration:**
    * H2 Database: `jdbc:h2:tcp://vsgate-s2.dei.isep.ipp.pt:10860/databaseName`
    * Connection credentials: admin/admin
    * H2 Driver initialization in `CustomerAppHttpServer.main()`

* **HTTP Endpoint Implementation:**
    * **GET /shows/scheduled?user={username}** - Main endpoint for listing scheduled shows
    * Request validation: Checks for required 'user' parameter
    * Returns JSON array of scheduled shows
    * HTTP Status: 200 OK for success, 400 Bad Request for missing parameters

* **Database Query (getScheduledShowsForUser method):**
    ```sql
    SELECT SP.NUMBER, SP.EVENTDATETIME, SP.LATITUDE, SP.LONGITUDE 
    FROM SHOW_PROPOSAL SP 
    JOIN REPRESENTATIVE R ON SP.CUSTOMER_NUMBER = R.CUSTOMER_VAT 
    WHERE R.SYSTEMUSER_USERNAME = ? AND SP.STATUS = 'SCHEDULED'
    ```
    * Filters by username through REPRESENTATIVE table join
    * Only shows with STATUS = 'SCHEDULED' (not ACCEPTED or REJECTED)
    * Returns show ID, date/time, and location coordinates

* **JSON Response Format:**
    * Each show returned as: `{"id":123,"dateTime":"2025-06-20T14:30:00Z","latitude":41.1496,"longitude":-8.6109}`
    * DateTime in ISO format (compatible with JavaScript Date parsing)
    * Coordinates as decimal degrees for mapping integration

* **Server Implementation:**
    * Thread-per-request model using `CustomerAppRequest extends Thread`
    * Socket-based HTTP server on configurable port
    * Request routing in `run()` method handles GET /shows/scheduled
    * Proper exception handling and resource cleanup

## 6. Integration/Demonstration

* The system integrates scheduled shows listing in the following ways:
    1. Customer Application Dashboard:
        * Primary menu option for "My Scheduled Shows"
        * Tabular display of upcoming shows
        * Quick filters for date ranges (This Week, This Month, All)
        * Click-to-view details functionality (links to US373)
        * Export/print options for show schedule

    2. Navigation Integration:
        * Seamless transition to show details view
        * Breadcrumb navigation support
        * Return to list functionality

    3. User Experience:
        * Loading indicators during data fetch
        * Empty state messaging when no shows scheduled
        * Error handling with user-friendly messages
        * Responsive design for mobile access

## 7. Testing

### 7.1 Functional Tests

**Test Case: List Scheduled Shows**
**ID:** #372  
**Description:** Retrieve list of scheduled shows for authenticated customer

**Prerequisites:**
1. Authenticate as Customer Representative with valid credentials
2. Have at least one show with STATUS = 'SCHEDULED' associated with the customer
3. Server running and database accessible

**Test Steps:**

1. **Normal show listing operation**
    1. Send GET request to `/shows/scheduled?user={username}`
    2. Verify HTTP 200 OK response
    3. Verify JSON array response format
    4. Confirm each show contains:
        * Show ID (NUMBER field)
        * DateTime in ISO format (EVENTDATETIME)
        * Latitude coordinate (LATITUDE)
        * Longitude coordinate (LONGITUDE)
    5. Verify only shows with STATUS = 'SCHEDULED' are returned
    6. Confirm shows belong to the authenticated customer

2. **Parameter validation testing**
    1. Send request without 'user' parameter: `/shows/scheduled`
    2. Verify HTTP 400 Bad Request response
    3. Verify error message: `{"error":"Parâmetro 'user' ausente ou inválido."}`
    4. Send request with empty user parameter: `/shows/scheduled?user=`
    5. Verify appropriate error handling

3. **Authorization and data isolation**
    1. Request shows for different customer usernames
    2. Verify each customer only sees their own scheduled shows
    3. Confirm database join correctly filters by REPRESENTATIVE table
    4. Verify no cross-customer data leakage

4. **Data accuracy verification**
    1. Compare returned show IDs with database records
    2. Verify DateTime format matches ISO standard (JavaScript compatible)
    3. Check coordinate precision (decimal degrees format)
    4. Confirm STATUS filtering works correctly
    5. Validate database connection handling and resource cleanup

5. **Edge cases and error handling**
    1. Test with user having no scheduled shows
    2. Verify empty JSON array `[]` response
    3. Test database connection failures
    4. Verify graceful error handling and logging
    5. Test with special characters in username parameter

**Expected Results:**
- Only scheduled shows for authenticated customer are returned
- JSON response format is consistent and parseable
- DateTime values are in ISO format for frontend compatibility
- Database queries execute efficiently with proper joins
- Error responses provide clear feedback for troubleshooting

**Test Data Requirements:**
- Multiple customers with different scheduled shows
- Shows with various STATUS values (SCHEDULED, ACCEPTED, REJECTED)
- Test users with CUSTOMER_REPRESENTATIVE role
- Valid REPRESENTATIVE table associations