<template>
    <div class="row gw-3">
        <div class="imagen">
            <img :src="logotipo" alt="logotipo" />
        </div>
        <div class="col-7 titulos">
            <h1 >{{ titulo }}</h1>
            <h2>{{ subtitulo }}</h2>
        </div>
    </div>

</template>
 
<script>
export default {
    data() {
        return {
            titulo: "Nombre del colegio",
            subtitulo: "Sistema de matriculas",
            logotipo:"/Logo.png",
            logotipo2: "https://images.vexels.com/media/users/3/224234/isolated/lists/ff7c525c1c3e1bef640644542001e1fd-logotipo-de-la-escuela-en-linea.png"
        }
    }
}
</script>

<style scoped>
.titulos {
    margin: 0;
    padding: 20px 0;
    color: #ffffff;
    font-size: medium;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-align: center;
}

.imagen {
    width: 190px;
    padding: 10px 10;
    margin-left: 100px;
}
</style>