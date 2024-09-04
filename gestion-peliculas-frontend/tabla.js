
document.addEventListener("DOMContentLoaded", function() {
    listarPeliculas();
});

// Function to display the modal
let showModal = (pelicula) => {
    // Fill the form with movie details
    document.getElementById("editId").value = pelicula.id;
    document.getElementById("editTitulo").value = pelicula.titulo;
    document.getElementById("editDirector").value = pelicula.director;
    document.getElementById("editGenero").value = pelicula.genero;

    document.getElementById("editModal").style.display = "block";
}

// Close modal when "X" button is clicked
document.querySelector(".close").addEventListener("click", function() {
    document.getElementById("editModal").style.display = "none";
});


// Add event listener to the Save Changes button
document.getElementById("saveChangesBtn").addEventListener("click", async function(event) {
    event.preventDefault();

    // Get updated movie details from the form
    let id = document.getElementById("editId").value;
    let updatedPelicula = {
        titulo: document.getElementById("editTitulo").value,
        director: document.getElementById("editDirector").value,
        genero: document.getElementById("editGenero").value
    };

    const peticion = await fetch("http://localhost:8080/api/pelicula/" + id, {
        method: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedPelicula)
    });

    // Close the modal and refresh the movie list
    document.getElementById("editModal").style.display = "none";
    listarPeliculas();
});


let currentPage = 0;

document.getElementById("prevPage").addEventListener("click", function() {
    if (currentPage > 0) {
        listarPeliculas(currentPage - 1);
    }
});

document.getElementById("nextPage").addEventListener("click", function() {
    listarPeliculas(currentPage + 1);
});

let listarPeliculas = async (page = 0) => {
    currentPage = page;

    const peticion = await fetch(`http://localhost:8080/api/pelicula/list?page=${currentPage}`, {
        method: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const response = await peticion.json();

    const peliculas = response.content;
    const totalPages = response.totalPages; // Número total de páginas

    let contenidoTabla = "";
    for (let pelicula of peliculas) {
        let contenidoFila = `<tr>
        <td>${pelicula.id}</td>
        <td>${pelicula.titulo}</td>
        <td>${pelicula.director}</td>
        <td>${pelicula.genero}</td>
        <td>
            <button class="action-btn edit" onclick='showModal(${JSON.stringify(pelicula)})'><i class="fas fa-pen"></i> Editar</button>
            <button onClick="borrarPelicula(${pelicula.id})" class="action-btn delete"><i class="fas fa-trash"></i> Eliminar</button>
        </td>
        </tr>`;

        contenidoTabla += contenidoFila;
    }

    document.querySelector("#tabla tbody").innerHTML = contenidoTabla;

    // Actualiza la información de la página
    document.getElementById("pageInfo").innerText = `Página ${currentPage + 1} de ${totalPages}`;

    // Maneja la habilitación/deshabilitación de los botones
    document.getElementById("prevPage").disabled = response.first;
    document.getElementById("nextPage").disabled = response.last;
}

// Inicializa la lista de películas con la primera página
listarPeliculas();




let borrarPelicula = async (id) => {
    // Show a confirmation dialog
    let confirmacion = confirm("¿Estás seguro de que quieres eliminar esta película?");

    // If the user confirms, proceed with deletion
    if (confirmacion) {
        const peticion = await fetch("http://localhost:8080/api/pelicula/" + id, {
            method: "DELETE",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

    
        listarPeliculas();
    }
};


