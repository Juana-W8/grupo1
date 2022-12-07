<template>
    <div class="contenido">
        <h1 class="titulos">
            {{ texto }}
        </h1>
        <div class="container">
            <form id="formularioestudiantes" class="row g-3">

                <div class="col-6">
                    <label for="id" class="form-label">ID</label>
                    <input v-model="id" type="number" class="form-control" id="id" placeholder="Digite el ID">
                </div>

                <div class="col-6">
                    <label for="identificacion" class="form-label">Identificacion</label>
                    <input v-model="identificacion" type="text" class="form-control" id="identificacion"
                        placeholder="Digite el numero de identidad">
                </div>

                <div class="col-6">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input v-model="nombre" type="text" class="form-control" id="nombre" placeholder="Digite el nombre">
                </div>


                <div class="col-6">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input v-model="apellido" type="text" class="form-control" id="apellido"
                        placeholder="Digite el apellido">
                </div>

                <div class="col-6">
                    <label for="curso" class="form-label">Curso</label>
                    <input v-model="curso" type="text" class="form-control" id="curso" placeholder="Digite el curso">
                </div>

                <div class="col-6">
                    <label for="montoMatricula" class="form-label">Monto de la matricula</label>
                    <input v-model="montoMatricula" type="text" class="form-control" id="montoMatricula"
                        placeholder="Digite el monto">
                </div>
                <div class="col-6">
                    <label for="estadoPago" class="form-label">Estado del pago</label>
                    <select v-model="estadoPago" class="form-select" aria-label="Default select example">
                        <option selected>Seleccione una opcion</option>
                        <option value="Pendiente">Pendiente</option>
                        <option value="Aceptado">Aceptado</option>
                        <option value="Rechazado">Rechazado</option>
                    </select>
                </div>

                <div class="col-6">

                    <label for="estadoMatricula" class="form-label">Estado de la matricula</label>
                    <input v-model="estadoMatricula" class="form-control" list="datalistOptions" id="estadoMatricula"
                        placeholder="estado">
                    <datalist id="datalistOptions">
                        <option value="Pendiente"></option>
                        <option value="Matriculado"></option>
                        <option value="Rechazado"></option>
                    </datalist>
                </div>

                <div>
                    <button v-on:click="crearEstudiante" class="boton col-3">Registrar estudiante</button>
                    <button v-on:click="actualizarEstudiante" class="boton col-3">Actualizar estudiante</button>
                </div>

            </form>
        </div>
    </div>
    <h2 class="titulos">{{texto2}}</h2>
    <div >
        <div class="contenido">
            <form id="formularioestudiantes" class="row g-3">

                <div class="col-3">
                    <label for="id" class="form-label">ID</label>
                    <input v-model="id" type="number" class="form-control" id="id" placeholder="Digite el ID">
                </div>

                <div>
                    <button @click="buscarEstudiante" class="boton col-3">Buscar estudiante</button>
                    <button @click="eliminarEstudiante" class="boton col-3">Eliminar estudiante</button>
                </div>
                
            </form>
            
        </div>
    </div>

    <div id="buscarEstudiante">
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
        

</template>

<script>
export default {
    data() {
        return {
            texto: "Información de estudiantes",
            texto2: "Busqueda",
            url: "http://localhost:8080/api/estudiantes",
            id: "",
            identificacion: "",
            nombre: "",
            apellido: "",
            curso: "",
            montoMatricula: "",
            estadoPago: "",
            estadoMatricula: "",
            estudiantes: [],
            token: ""
        }
    },
    methods: {
        limpiarFormulario() {
            this.id = 0;
            this.identificacion = "";
            this.nombre = "";
            this.apellido = "";
            this.curso = "";
            this.estadoMatricula = "";
            this.estadoPago = "";
            this.montoMatricula = "";
        },
        crearEstudiante() {
            const opciones = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer '+this.token

                },
                body: JSON.stringify({

                    id: this.id,
                    identificacion: this.identificacion,
                    nombre: this.nombre,
                    apellido: this.apellido,
                    curso: this.curso,
                    estadoMatricula: this.estadoMatricula,
                    montoMatricula: this.montoMatricula,
                    estadoPago: this.estadoPago

                })
            };
            fetch(this.url, opciones).then(async (response) => {
                if (response.ok) {
                    const data = await response.json();
                    console.log(data);
                    this.limpiarFormulario();

                } else {
                    const error = new Error(response.statusText);
                    error.json = response.json();
                    console.log(error.message);

                    throw error;
                }
            })
        },
        actualizarEstudiante() {
            const opciones = {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer '+this.token

                },
                body: JSON.stringify({

                    id: this.id,
                    identificacion: this.identificacion,
                    nombre: this.nombre,
                    apellido: this.apellido,
                    curso: this.curso,
                    estadoMatricula: this.estadoMatricula,
                    montoMatricula: this.montoMatricula,
                    estadoPago: this.estadoPago

                })
            };
            fetch(this.url + "/" + this.id, opciones).then(async (response) => {
                if (response.ok) {
                    const data = await response.json();
                    console.log(data);
                    this.limpiarFormulario();

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
        },
        buscarEstudiante() {
            const opciones = {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic dXNlcjozNmM4ZjIxOS1hOTAzLTQ5M2YtODAwMS0yYzBiYTdhZWI0Y2M='

                }
            };
            fetch(this.url + "/" + this.id, opciones).then(async (response) => {
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
        eliminarEstudiante() {
            const opciones = {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer '+this.token

                }
            };
            fetch(this.url + "/" + this.id, opciones).then(async (response) => {
                if (response.ok) {
                    data = await response.json();
                    console.log(data);
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
        this.solicitarToken();
    }

};


</script>

<style scoped>
.contenido {
    padding: 20px 20px;
    color: rgb(87, 160, 65);
}

.boton {

    background-color: rgb(31, 151, 43);
    border-color: rgb(57, 159, 36);
    color: rgb(245, 248, 251);
    padding: 12px 50px;
    margin: 14px;
    font-size: 18px;
}

.titulos {
    text-align: center;
    color: rgb(87, 160, 65);
}
</style>