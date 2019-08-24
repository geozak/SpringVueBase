<template>
  <div>
    <h1>Visit Counter</h1>
    <p>
      The site has been visited
      {{ visitCount ? visitCount : '[Calculating...]' }} times.
    </p>
  </div>
</template>

<script>
import CounterService from '@/services/CounterService.js';

export default {
  data() {
    return {
      visitCount: null
    };
  },

  created() {
    console.log('Starting Call');
    CounterService.getVisitCount()
      .then(response => {
        this.visitCount = response.data;
      })
      .catch(error => {
        this.visitCount = 'error';
        console.log('There was an error:', error.response);
      });
  }
};
</script>

<style lang="scss" scoped></style>
