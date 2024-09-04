let boton = document.getElementById("btnRegistrar");

boton.addEventListener("click", evento => {
    evento.preventDefault();  // Prevenir la acción predeterminada del formulario
    registrarPelicula();
});

let registrarPelicula = async () => {
    let campos = {};

    campos.titulo = document.getElementById("titulo").value;
    campos.director = document.getElementById("director").value;
    campos.genero = document.getElementById("genero").value;

    try {
        const respuesta = await fetch("http://localhost:8080/api/pelicula/create", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(campos)
        });

        if (respuesta.ok) {  // Si la respuesta es satisfactoria
            alert("La película fue creada con éxito");
            location.reload();
        } else {
            alert("Error al crear la película");
        }
    } catch (error) {
        alert("Hubo un problema al conectar con el servidor");
    }
};

let limpiarCampos = () => {
    document.getElementById("titulo").value = '';
    document.getElementById("director").value = '';
    document.getElementById("genero").value = '';
};


