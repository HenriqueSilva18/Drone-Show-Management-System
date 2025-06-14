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


// --- NOVAS FUNÇÕES PARA "Check shows dates" ---
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