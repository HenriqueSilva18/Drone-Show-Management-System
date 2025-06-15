// Aguarda o carregamento completo do HTML antes de executar o script
document.addEventListener('DOMContentLoaded', () => {
    const username = sessionStorage.getItem('loggedInUser');
    if (!username) {
        alert('You are not logged in. Redirecting to login page.');
        window.location.href = '/index.html';
        return;
    }
    document.getElementById('welcome-user').textContent = `Welcome, ${username}!`;
});

// --- Constantes para elementos do DOM ---
const modal = document.getElementById('mainModal');
const modalTitle = document.getElementById('modalTitle');
const modalContent = document.getElementById('modalContent');

function logout() {
    sessionStorage.removeItem('loggedInUser');
    window.location.href = '/index.html';
}

function closeModal() {
    modal.style.display = 'none';
}

function showGenericModal(title) {
    modalTitle.innerText = title;
    modalContent.innerHTML = `<p>This feature (${title}) is not yet implemented.</p>`;
    modal.style.display = 'flex';
}

// --- Funções para "Analyse a proposal" ---
async function showAnalyseProposalModal() {
    const username = sessionStorage.getItem('loggedInUser');
    modalTitle.innerText = 'Analyse a proposal';
    modalContent.innerHTML = '<p>Loading proposals...</p>';
    modal.style.display = 'flex';
    try {
        const response = await fetch(`/proposals?user=${username}`);
        if (!response.ok) throw new Error('Server error!');
        const proposals = await response.json();
        populateProposalsTable(proposals);
    } catch (error) {
        console.error('Failed to fetch proposals:', error);
        modalContent.innerHTML = '<p>Could not fetch proposals from the server.</p>';
    }
}

function populateProposalsTable(proposals) {
    if (proposals.length === 0) {
        modalContent.innerHTML = '<p>No pending proposals found to analyse.</p>';
        return;
    }
    let tableHTML = '<table class="proposals-table"><tr><th>ID</th><th>Name</th><th>Action</th></tr>';
    proposals.forEach(p => {
        const safeText = p.text.replace(/"/g, '&quot;');
        tableHTML += `<tr><td>${p.id}</td><td>${p.name}</td><td><button class="download-btn" data-proposal-text="${safeText}" data-proposal-id="${p.id}" onclick="downloadProposal(this)">Download</button></td></tr>`;
    });
    tableHTML += '</table>';
    modalContent.innerHTML = tableHTML;
}

function downloadProposal(button) {
    const proposalText = button.getAttribute('data-proposal-text');
    const proposalId = button.getAttribute('data-proposal-id');
    const blob = new Blob([proposalText], { type: 'text/plain;charset=utf-8' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `proposal_${proposalId}.txt`;
    document.body.appendChild(a);
    a.click();
    window.URL.revokeObjectURL(url);
    document.body.removeChild(a);
}


// --- Funções para "Accept/reject proposal" ---
async function showAcceptRejectModal() {
    const username = sessionStorage.getItem('loggedInUser');
    modalTitle.innerText = 'Accept or Reject Proposals';
    modalContent.innerHTML = '<p>Loading proposals for decision...</p>';
    modal.style.display = 'flex';
    try {
        const response = await fetch(`/proposals?user=${username}`);
        if (!response.ok) throw new Error('Server error!');
        const proposals = await response.json();
        populateAcceptRejectTable(proposals);
    } catch (error) {
        console.error('Failed to fetch proposals for decision:', error);
        modalContent.innerHTML = '<p>Could not fetch proposals from the server.</p>';
    }
}

function populateAcceptRejectTable(proposals) {
    if (proposals.length === 0) {
        modalContent.innerHTML = '<p>There are no proposals awaiting a decision.</p>';
        return;
    }
    let tableHTML = `<table class="proposals-table"><tr><th>ID</th><th>Name</th><th style="text-align:center;">Action</th></tr>`;
    proposals.forEach(p => {
        tableHTML += `<tr><td>${p.id}</td><td>${p.name}</td><td class="decision-buttons"><button class="accept-btn" onclick="submitDecision('${p.id}', 'ACCEPTED')">✓ Accept</button><button class="reject-btn" onclick="submitDecision('${p.id}', 'REJECTED')">✗ Reject</button></td></tr>`;
    });
    tableHTML += '</table>';
    modalContent.innerHTML = tableHTML;
}

async function submitDecision(proposalId, decision) {
    if (!confirm(`Are you sure you want to ${decision.toLowerCase()} this proposal?`)) return;
    const payload = { id: parseInt(proposalId), status: decision };
    try {
        const response = await fetch('/proposal/decision', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(payload)
        });
        if (response.ok) {
            alert('Decision submitted successfully!');
            showAcceptRejectModal();
        } else {
            alert(`Error: ${await response.text()}`);
        }
    } catch (error) {
        alert('A network error occurred.');
        console.error('Fetch error:', error);
    }
}

async function showShowsDatesModal() {
    const username = sessionStorage.getItem('loggedInUser');
    modalTitle.innerText = 'Scheduled Shows';
    modalContent.innerHTML = '<p>Loading scheduled shows...</p>';
    modal.style.display = 'flex';
    try {
        const response = await fetch(`/shows/scheduled?user=${username}`);
        if (!response.ok) throw new Error('Server error!');
        const shows = await response.json();
        populateShowsDatesTable(shows);
    } catch (error) {
        console.error('Failed to fetch scheduled shows:', error);
        modalContent.innerHTML = '<p>Could not fetch scheduled shows from the server.</p>';
    }
}

function populateShowsDatesTable(shows) {
    if (shows.length === 0) {
        modalContent.innerHTML = '<p>No scheduled shows found.</p>';
        return;
    }
    let tableHTML = `<table class="proposals-table"><tr><th>Proposal ID</th><th>Date & Time</th><th>Latitude</th><th>Longitude</th></tr>`;
    shows.forEach(s => {
        const formattedDate = new Date(s.dateTime).toLocaleString('pt-PT', { year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit' });
        tableHTML += `<tr><td>${s.id}</td><td>${formattedDate}</td><td>${s.latitude.toFixed(6)}</td><td>${s.longitude.toFixed(6)}</td></tr>`;
    });
    tableHTML += '</table>';
    modalContent.innerHTML = tableHTML;
}

/**
 * Mostra a modal para "Get show info", começando por listar os espetáculos disponíveis.
 */
async function showGetShowInfoModal() {
    const username = sessionStorage.getItem('loggedInUser');
    modalTitle.innerText = 'Select a Show to View Details';
    modalContent.innerHTML = '<p>Loading shows...</p>';
    modal.style.display = 'flex';

    try {
        // Reutilizamos o endpoint que busca shows aceites
        const response = await fetch(`/shows/scheduled?user=${username}`);
        if (!response.ok) throw new Error('Server error!');

        const shows = await response.json();
        // Usamos uma nova função para popular a tabela, que permite selecionar um show
        populateShowSelectionTable(shows);

    } catch (error) {
        console.error('Failed to fetch shows:', error);
        modalContent.innerHTML = '<p>Could not fetch shows from the server.</p>';
    }
}

/**
 * Cria a tabela de espetáculos com um botão "View Details" para cada um.
 */
function populateShowSelectionTable(shows) {
    if (shows.length === 0) {
        modalContent.innerHTML = '<p>No scheduled shows available to view.</p>';
        return;
    }

    let tableHTML = `<table class="proposals-table">
                       <tr><th>Proposal ID</th><th>Date & Time</th><th>Action</th></tr>`;
    shows.forEach(s => {
        const formattedDate = new Date(s.dateTime).toLocaleString('pt-PT');
        tableHTML += `<tr>
                        <td>${s.id}</td>
                        <td>${formattedDate}</td>
                        <td><button class="view-btn" onclick="fetchAndDisplayShowDetails(${s.id})">View Details</button></td>
                     </tr>`;
    });
    tableHTML += '</table>';
    modalContent.innerHTML = tableHTML;
}

/**
 * Busca os detalhes completos de um espetáculo e chama a função para os mostrar.
 */
async function fetchAndDisplayShowDetails(showId) {
    modalContent.innerHTML = '<p>Loading show details...</p>';
    try {
        const response = await fetch(`/show/details?id=${showId}`);
        if (!response.ok) throw new Error('Show not found or server error!');

        const details = await response.json();
        displayShowDetails(details);
    } catch (error) {
        console.error('Failed to fetch show details:', error);
        modalContent.innerHTML = `<p>${error.message}</p>`;
    }
}

/**
 * Mostra os detalhes completos de um show.
 */
function displayShowDetails(details) {
    const formattedDate = new Date(details.dateTime).toLocaleString('pt-PT');

    // Cria as listas de drones e figuras
    let dronesList = details.drones.map(d => `<li>${d.quantity}x ${d.name}</li>`).join('');
    let figuresList = details.figures.map(f => `<li><b>${f.name}:</b> ${f.description}</li>`).join('');

    // Prepara o texto da proposta para download
    const safeText = details.proposalText ? details.proposalText.replace(/"/g, '&quot;') : '';

    modalTitle.innerText = `Details for Show #${details.id}`;
    modalContent.innerHTML = `
        <button class="back-btn" onclick="showGetShowInfoModal()">← Back to Show List</button>
        <button class="download-btn" data-proposal-text="${safeText}" data-proposal-id="${details.id}" onclick="downloadProposal(this)">Download</button>
        <h3>Show Information</h3>
        <ul>
            <li><b>Date & Time:</b> ${formattedDate}</li>
            <li><b>Duration:</b> ${details.duration} minutes</li>
            <li><b>Location:</b> Lat ${details.latitude.toFixed(6)}, Lon ${details.longitude.toFixed(6)}</li>
            <li><b>Insurance Value:</b> €${details.insuranceValue.toFixed(2)}</li>
            <li><b>Manager:</b> ${details.firstName} ${details.lastName}</li>
            <li><b>Simulation Video:</b> <a href="${details.simulationVideoLink}" target="_blank">Watch video</a></li>
        </ul>
        <h3>Drones in Show</h3>
        <ul>${dronesList || '<li>No drones specified.</li>'}</ul>
        <h3>Figures in Show</h3>
        <ul>${figuresList || '<li>No figures specified.</li>'}</ul>
    `;
}