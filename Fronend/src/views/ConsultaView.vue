<template>
    <div class="container">
        <div class="contenido">
            <h1 class="titulos">
                {{ texto }}
            </h1><br />
            <div id="consultaEstudiantes">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Identificacion</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Curso</th>
                            <th scope="col">Monto de la matricula</th>
                            <th scope="col">Estado del pago</th>
                            <th scope="col">Estado de la matricula</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="estudiante in estudiantes">
                            <td>{{ estudiante.id }}</td>
                            <td>{{ estudiante.identificacion }}</td>
                            <td>{{ estudiante.nombre }}</td>
                            <td>{{ estudiante.apellido }}</td>
                            <td>{{ estudiante.curso }}</td>
                            <td>{{ estudiante.montoMatricula }}</td>
                            <td>{{ estudiante.estadoPago }}</td>
                            <td>{{ estudiante.estadoMatricula }}</td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            texto: "Listado de estudiantes",
            url: "http://localhost:8080/api/estudiantes",
            estudiantes: [],
            token: ""
        }
    },
    methods: {

        consultaEstudiantes() {
            const opciones = {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer '+this.token

                }
            };
            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    this.estudiantes = await response.json();
                    console.log(this.estudiantes);
                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        },
        solicitarToken(){
            const opciones = {
                method:'POST',
                headers:{
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    usuario: "prueba",
                    clave: "123"
                })
            };
            fetch("http://localhost:8080/api/token", opciones).then(async (response)=>{
                if (response.ok) {
                    const data = await response.json();
                    console.log(data);
                    this.token= data.token;
                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);
                    throw error;
                }
            })
        }
    },
    beforeMount() {
        this.consultaEstudiantes();
        this.solicitarToken();
    }

}
</script>

<style scoped>
.contenido {
    margin-top: 10px;
    margin-left: 5px;
    margin-right: 5px;
    color: rgb(87, 160, 65);
}

.boton {

    background-color: rgb(31, 151, 43);
    border-color: rgb(57, 159, 36);
    color: rgb(245, 248, 251);
    padding: 12px 50px;
    margin: 14px 500px;
    font-size: 18px;
}

.titulos {
    text-align: center;
}
</style>