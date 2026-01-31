<script setup>
import { ref, onMounted } from 'vue'

const usuarios = ref([])
const usuario = ref('')
const password = ref('')

const API_URL = 'http://localhost:8080/api/usuarios'

// Obtener usuarios
const cargarUsuarios = async () => {
  const res = await fetch(API_URL)
  usuarios.value = await res.json()
}

// Guardar usuario
const guardarUsuario = async () => {
  await fetch(API_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      usuario: usuario.value,
      password: password.value
    })
  })

  usuario.value = ''
  password.value = ''
  cargarUsuarios()
}

onMounted(cargarUsuarios)
</script>

<template>
  <h2>Registrar usuario</h2>

  <input v-model="usuario" placeholder="Usuario" />
  <input v-model="password" placeholder="Password" type="password" />
  <button @click="guardarUsuario">Guardar</button>

  <hr />

  <h2>Usuarios registrados</h2>
  <ul>
    <li v-for="u in usuarios" :key="u.id">
      {{ u.usuario }}
    </li>
  </ul>
</template>
