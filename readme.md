
<h1>Shodrone - Drone Show Management System 🚁✨</h1>

<h2>My Role 👨‍💻</h2>
<p><strong>Responsible for software design, application development (Java/ANTLR), and project management (excluding the C-based SCOMP simulation engine).</strong></p>
<p>📄 <strong>Project Outline:</strong> <a href="./Project_Outline.pdf">Project_Outline.pdf</a></p>

<h2>Description</h2>
<p>Welcome to <strong>Shodrone</strong>! 🌍🚁

This is a comprehensive management system for a company specializing in immersive drone multimedia shows. Developed as the Integrative Project for the 4th semester of the Informatics Engineering degree at `<strong>`ISEP`</strong>` (2024-2025), this solution bridges the gap between high-level show design and low-level hardware simulation.`</p>`

<p>The system is a multi-disciplinary engineering feat, integrating <strong>Applications Engineering (EAPLI)</strong>, <strong>Computer Systems (SCOMP)</strong>, <strong>Language Processing (LPROG)</strong>, and <strong>Computer Networks (RCOMP)</strong>. It allows administrators to manage drone inventories, designers to craft intricate choreographies using custom languages, and engineers to simulate flight paths safely before physical deployment.</p>
<br />

<h2>Technologies Stack 🛠️</h2>
<ul>
<li><strong>Core Application:</strong> Java 17 ☕, Maven 📦, JPA/Hibernate (Persistence)</li>
<li><strong>Simulation Engine:</strong> C Language (Linux/Unix Systems) ⚙️</li>
<li><strong>Language Processing:</strong> ANTLR4 (for custom DSLs and parsing) 🗣️</li>
<li><strong>Database:</strong> H2 (Embedded) 💾</li>
<li><strong>Concurrency:</strong> Multi-processing with `fork()`, Pipes, and Signals (SIGUSR1/SIGTERM)</li>
<li><strong>Testing:</strong> JUnit 5 🧪</li>
</ul>

<h2>Key Features 🚀</h2>

<h3>🌐 Core Management (Backoffice)</h3>
<ul>
<li><strong>Inventory Command:</strong> Complete lifecycle management for Drones, Drone Models, and spare parts.</li>
<li><strong>CRM & Security:</strong> Robust role-based access control (RBAC) for Administrators, Managers, and Clients. Manage customer portfolios and service requests.</li>
<li><strong>Show Logistics:</strong> Schedule shows, manage flight plans, and assign specific drone fleets to upcoming events.</li>
</ul>

<h3>🧠 Language & Compilers (LPROG)</h3>
<ul>
<li><strong>Modular Plugin Architecture:</strong> A dynamic system that supports multiple drone programming languages via plugins.</li>
<li><strong>Custom DSLs:</strong> Tailor-made Domain-Specific Languages for defining geometric figures and light sequences.</li>
<li><strong>Smart Validation:</strong> Semantic and syntactic analysis of flight scripts to ensure valid maneuvers before they ever reach a drone.</li>
<li><strong>Automated Generation:</strong> Generate high-level show descriptions and low-level flight instructions automatically.</li>
</ul>

<h3>⚙️ Physics Simulation Engine (SCOMP)</h3>
<ul>
<li><strong>High-Performance Simulation:</strong> A C-based engine where every drone is an independent process.</li>
<li><strong>Real-time Telemetry:</strong> Inter-process communication via **Pipes** to stream coordinates and status updates.</li>
<li><strong>Collision Avoidance System:</strong> Real-time monitoring of Euclidean distances between drones; triggers emergency stop signals (`SIGUSR1`) upon detecting potential crashes.</li>
<li><strong>Detailed Reporting:</strong> Generates post-simulation analytics on trajectory safety and battery consumption.</li>
</ul>

<h2>Project Structure 📂</h2>
<ul>
<li><code>shodrone.app.backoffice.console</code>: The administrative heart of the system.</li>
<li><code>shodrone.core</code>: Business logic and domain entities (DDD approach).</li>
<li><code>SCOMP/Sprint_2</code> & <code>Sprint3</code>: The C source code for the low-level simulation engine.</li>
<li><code>LPROG/</code>: ANTLR grammar files (`.g4`) and plugin implementations.</li>
<li><code>shodrone.persistence.impl</code>: Data access layers (JPA/In-memory).</li>
</ul>

<h2>How to Run 🏃‍♂️</h2>

<h3>Prerequisites</h3>
<ul>
<li>Java 17+</li>
<li>GCC Compiler (for the simulation engine)</li>
<li>Maven</li>
</ul>

<h3>Build</h3>
<pre><code>./build-all.sh  # On Linux/Mac
build-all.bat   # On Windows</code></pre>

<h3>Execute</h3>
<pre><code>./run-backoffice.sh  # Launch the Management UI
./run-user.sh        # Launch the Client Portal</code></pre>

<br />
<h2>Team 👨‍💻</h2>
<p><strong>1230596</strong> - José Sousa | <strong>1230595</strong> - João Ribeiro | <strong>1220848</strong> - José Moreira | <strong>1240586</strong> - Duarte Machado | <strong>1240588</strong> - Henrique Silva</p>
