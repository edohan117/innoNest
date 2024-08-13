<template>
  <div class="toolbar">
    <button @click="formatText('bold')">Bold</button>
    <button @click="formatText('italic')">Italic</button>
    <button @click="formatText('underline')">Underline</button>
  </div>
</template>

<script>
export default {
  methods: {
    formatText(command) {
      document.execCommand(command, false, null);
    }
  }
}
</script>

<style>
.toolbar {
  padding: 10px;
  background-color: #f0f0f0;
}

.toolbar button {
  margin-right: 10px;
}
</style>
