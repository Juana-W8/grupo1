<template>
    <div class="col-5">
       <img :src="imagen" alt="imagenHome" class="imagen" />
    </div>
</template>

<script>
    export default{
        data(){
            return{
                imagen: "https://img.freepik.com/fotos-premium/ninos-felices-uniforme-formal-disfrutan-dia-soleado-al-aire-libre-despues-dia-conocimiento-estudios-escolares_474717-72335.jpg"
            }
        }
    }
</script>

<style scoped>
.imagen {
    width: 800px;
    padding: 20px 10px;
}
</style>