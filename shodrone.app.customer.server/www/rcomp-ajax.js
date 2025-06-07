/**
 * Ficheiro JavaScript para interagir com a API de Gestão de Propostas.
 */

// Função principal para carregar e mostrar as propostas do servidor.
function loadProposals() {
    const request = new XMLHttpRequest();
    const container = document.getElementById("proposals-container");

    request.onload = function() {
        // Passo 1: Interpretar a resposta JSON do servidor.
        const proposals = JSON.parse(this.responseText);

        // Passo 2: Construir o HTML da tabela dinamicamente.
        let html = `
            <table>
                <thead>
                    <tr>
                        <th>Número</th>
                        <th>Cliente (VAT)</th>
                        <th>Duração (min)</th>
                        <th>Estado</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
        `;

        // Passo 3: Criar uma linha na tabela para cada proposta.
        for (const p of proposals) {
            html += `
                <tr>
                    <td>${p.number}</td>
                    <td>${p.customerVAT}</td>
                    <td>${p.eventDuration}</td>
                    <td>${p.status}</td>
                    <td>
                        <button onclick="acceptProposal(${p.number})">Aceitar</button>
                        <button onclick="rejectProposal(${p.number})">Rejeitar</button>
                    </td>
                </tr>
            `;
        }

        html += `</tbody></table>`;

        container.innerHTML = html;
    };

    request.onerror = function() {
        container.innerHTML = "<p>Erro de ligação. Não foi possível obter as propostas.</p>";
    };

    request.open("GET", "/api/proposals", true);
    request.send();
}

/**
 * Envia um pedido para aceitar uma proposta.
 * @param {number} proposalId - O número da proposta a aceitar.
 */
function acceptProposal(proposalId) {
    console.log("A tentar aceitar a proposta: " + proposalId);
    const request = new XMLHttpRequest();

    request.onload = function() {
        if (this.status === 200) {
            alert("Proposta " + proposalId + " aceite com sucesso!");
            loadProposals(); // Recarrega a lista para mostrar o estado atualizado.
        } else {
            alert("Erro ao aceitar a proposta " + proposalId + ".");
        }
    };

    // Envia um pedido PUT para o endpoint de aceitação.
    request.open("PUT", `/api/proposals/${proposalId}/accept`, true);
    request.send();
}

/**
 * Envia um pedido para rejeitar uma proposta.
 * @param {number} proposalId - O número da proposta a rejeitar.
 */
function rejectProposal(proposalId) {
    console.log("A tentar rejeitar a proposta: " + proposalId);
    const request = new XMLHttpRequest();

    request.onload = function() {
        if (this.status === 200) {
            alert("Proposta " + proposalId + " rejeitada com sucesso!");
            loadProposals(); // Recarrega a lista para mostrar o estado atualizado.
        } else {
            alert("Erro ao rejeitar a proposta " + proposalId + ".");
        }
    };

    // Envia um pedido PUT para o endpoint de rejeição.
    request.open("PUT", `/api/proposals/${proposalId}/reject`, true);
    request.send();
}