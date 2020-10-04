<template>
<div>
  <p>
  Nice to meet you at the description page!
  </p>
  <br>
  Probably, you came here to learn something about this website. Sorry to disappoint you, but:
  <h1> You came there for nothing</h1>
  <p>
    It is literally no a single bit of information I will share with you to put some light on the purpose of this web application.
  </p>
  <p>
    And you are just wasting your time reading this wall of text.
    <br>
    Just think about things you could do instead of it:
  </p>
  <ul class="activities">
    <li class="activity">You could eat some food.</li>
    <li class="activity">You could take a rest.</li>
    <li class="activity">You could write some useful web-application.</li>
    <li class="activity">You could save the world, anyway.</li>
  </ul>
  <h2>But instead of doing it, you are here.</h2>
  <p> Honestly, I do not understand your reasons.</p>
  <p>
    Ok, so now I will leave you with regrets about your miserably wasted time.
  </p>
  <p>
    That is it, description page ends.
  </p>
</div>
</template>

<script>
export default {
name: "AboutDescription"
}
</script>

<style scoped>
h1 {
  font-size: 300%;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: decimal;
  padding: 0;
}
.activities {
  display: inline-block;
  margin: 10px 10px;
}
.activity {
  margin: 10px;
}
a {
  color: #42b983;
}
</style>