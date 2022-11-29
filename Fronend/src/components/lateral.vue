<template>
    <br/>
    <p>{{ textoBienvenida }}</p>
    <p>{{ texto }}</p>
    <form class="row g-3 contenido">

        <div class="mb-3">
            <label for="usuario" class="form-label">Usuario</label>
            <input type="email" class="form-control" id="user" placeholder="Usuario123">
        </div>
        <div class="mb-3">
            <label for="contrasenia" class="form-label">Contraseña</label>
            <input type="password" class="form-control" id="password" placeholder="contraseña">
        </div>
        <button type="button" class="btn btn-success">Ingresar</button>
    </form>
</template>

<script>
export default {
    data() {
        return {
            textoBienvenida: "Bienvenido al sistema de matriculas en el cual podras llevar un registro de tus estudiantes",
            texto: "Ingrese su información por favor"
        }
    }
}
</script>

<style scoped>
p {
    color: rgb(9, 80, 41);
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
    font-size: 20px;
    margin-top: 30px;
}

.contenido {
    color: black;
    align-items: center;
    padding: 25px 10px;
}
</style>