const access = document.getElementById('Access');
const guest = document.getElementById('LogAsGuest');
const db_conn = document.getElementById('db_connection');

if(access){
    access.addEventListener('click', function(){
        window.location.href = 'log_in.html';
    });
}
if(guest){
    guest.addEventListener('click', function(){
        window.location.href = 'dashboard.html';
    });
}

document.addEventListener("DOMContentLoaded", function() {
    // Cridem a l'endpoint de l'API fent un fetch
    fetch("http://127.0.0.1:8000/presencia")
        .then(response =>{
            if (!response.ok) {
                throw new Error("Error a la resposta del servidor");
            }
            return response.json();
        })
        .then(data => {
            const PresenciaTableBody = document.querySelector("#tablaPresencia tbody");
            PresenciaTableBody.innerHTML = ""; // Netejar la taula abans d'afegir res
            
            // Iterar sobre los alumnos y agregarlos al DOM
            data.forEach(alumne => {
                const row = document.createElement("tr");

                const nomAluCell = document.createElement("td");
                nomAluCell.textContent = PRESENCIA.IdAlumne;
                row.appendChild(nomAluCell);

                const classeAluCell = document.createElement("td");
                classeAluCell.textContent = PRESENCIA.IdClasse;
                row.appendChild(classeAluCell);

                const presentAluCell = document.createElement("td");
                presentAluCell.textContent = PRESENCIA.Present;
                row.appendChild(presentAluCell);

                const comentAluCell = document.createElement("td");
                comentAluCell.textContent = PRESENCIA.Comentaris;
                row.appendChild(comentAluCell);

                PresenciaTableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error("Error capturat:", error);
            alert("Error al carregar la llista d'alumnes");
        });
});