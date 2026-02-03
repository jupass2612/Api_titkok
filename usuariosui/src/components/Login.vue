<template>
  <div class="login-container">
    <h2>Login</h2>

    <input
      type="text"
      placeholder="Usuario"
      v-model="usuario"
    />

    <input
      type="password"
      placeholder="Contraseña"
      v-model="password"
    />

    <button @click="login">Iniciar sesión</button>

    <p v-if="mensaje">{{ mensaje }}</p>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      usuario: "",
      password: "",
      mensaje: ""
    };
  },
  methods: {
    async login() {
      try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            usuario: this.usuario,
            password: this.password
          })
        });

        if (!response.ok) {
          throw new Error("Credenciales incorrectas");
        }

        const data = await response.json();
        this.mensaje = "Login exitoso ";
        console.log(data);
      } catch (error) {
        this.mensaje = "Usuario o contraseña incorrectos ";
      }
    }
  }
};
</script>

<style scoped>
.login-container {
  width: 300px;
  margin: 100px auto;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

input, button {
  padding: 10px;
  font-size: 16px;
}

button {
  cursor: pointer;
}
</style>
