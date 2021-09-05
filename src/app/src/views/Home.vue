<template>
  <div id="home">
    <!-- <img class="logo" src="../assets/logo.png" alt="logo" /> -->
    <h1>👋Hello Spring Vue Fans🌎</h1>
    <button @click="getMessage">Click me to make a server call...</button>
    <div>
      <code>{{ response }}</code>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "home",
  data() {
    return {
      response: null,
    };
  },
  methods: {
    getMessage() {
      const self = this;
      axios.get(`${apiBase}/api/message`).then(function(response) {
        self.response = response.data;
      });
    },
  },
};
</script>

<style scoped>
button{
  min-width: 130px;
  height: 40px;
  color: #fff;
  padding: 5px 10px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
  outline: none;
  border: 2px solid #ff0a78;
  background: #ff0a78;
}
button:hover {
  background: #fff;
  color: #ff0a78
}
</style>
