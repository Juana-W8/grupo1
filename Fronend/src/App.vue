<template>
    <div class="container fondo">
        <div class="row barra">
            <nav>
                <Encabezados />
            </nav>

        </div>
        <div class="row">
            <ul class="nav opciones">
                <li class="nav-item ">
                    <RouterLink class="nav-link active " to="/">Inicio</RouterLink>
                </li>
                <li class="nav-item ">
                    <RouterLink class="nav-link " to="/estudiantes">Estudiantes</RouterLink>
                </li>
                <li class="nav-item ">
                    <RouterLink class="nav-link " to="/consulta">Listado</RouterLink>
                </li>
            </ul>
        </div>
       
        <div class="row contenido">
            <RouterView />
        </div>
        <div class="row barra">
            <Pie />
        </div>
    </div>
</template>

<script>
import { RouterLink, RouterView } from 'vue-router';
import Encabezados from './components/encabezados.vue';
import Pie from './components/pie.vue';

export default {
    data() {
        return {

        };
    },
    components: { Encabezados, Pie }
}
</script>

<style scoped>
.contenido {
    min-height: 500px;
    border: 1px solid #ccc;
    color: coral;
    background-color: rgb(255, 255, 255);
}

.opciones {
    background-color: rgb(188, 203, 214);
    font-size: 30;
    text-align: center;
    font-family: Arial, Helvetica, sans-serif;
}

.barra {
    background-color: rgb(17, 143, 171);
}

</style>