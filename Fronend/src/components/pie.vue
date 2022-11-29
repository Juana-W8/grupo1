<template>
    <div class="row">
        <nav>
            <p>{{creditos}}</p>
        </nav>
        
    </div>
</template>

<script>
    export default{
        data(){
            return{
                creditos: "Derechos de autor reservados"
            }
        }
    }
</script>

<style scoped>
p{
    color: rgb(255, 255, 255);
    font-size: 45;
    margin-top: 25px;
    padding: 40px 40px;
    text-align: center;
}
</style>