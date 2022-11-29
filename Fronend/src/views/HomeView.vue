<template>
    <div class="row">
        <div class="col-md-8">
            <Home/>
        </div>
        <div class="col-md-4">
            <Lateral/>
        </div>
    </div>
</template>

<script>

import Home from '../components/home.vue';
import Lateral from '../components/lateral.vue';
    export default{
        components: { Home, Lateral }
    }

</script>

<style scoped>

</style>