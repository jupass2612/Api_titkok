<template>
  <main class="min-h-screen bg-[#f3f4f6] selection:bg-black selection:text-white">
    <Usuarios />
  </main>
</template>

<script setup>
import Usuarios from './components/Usuarios.vue'
</script>

<style>
/* Reset básico para asegurar que no haya márgenes extra */
body {
  margin: 0;
  padding: 0;
  overflow-x: hidden;
}
</style>