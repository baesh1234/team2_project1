<template>
  <div class="section s1">
    <div class="section1">
      <div class="section1_header">
        <div class="section1_logo"></div>

        <div class="section1_headline">

          <!-- <p>블루 아카이브 100주년 기념 특설페이지</p> -->
        </div>
        <audio data-autoplay data-keepplaying controls loop onloadstart="this.volume=0.5" class="section1_bgm">
          <source src="https://epsilon.vgmsite.com/soundtracks/blue-archive-gamerip/pgcasqoumy/07%20Mitsukiyo%2005%20Unwelcome%20School.mp3" type="audio/mp3">
        </audio>

      </div>
      <div class="section1_space">

      </div>


      <div class="section1_PV">
        <iframe width="1080" height="540" src="https://www.youtube.com/embed/gMZ1BWFLDMw?si=zQNFoc5wwx7jMcVG" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Section1'
}
</script>
<style scoped>
/*Section１*/
.section1{
  text-align: center;
}

.section1_header{
  position: relative;
}

.section1_logo{
  position: absolute;
  width: 320px;
  height: 110px;
  background-image: url('../assets/images/blueachalogo.png');
  background-repeat: no-repeat;
  background-size: cover;
  left: 0; top: 0; margin: 0 auto;
}


.section1_headline{
  width: 841px; height: 474px;
  background-image: url('../assets/images/blueachive2.png');
  position: absolute;
  right: 0; left: 0%; margin: 0 auto;
}

.section1_bgm{
  position: absolute;
  right: 0; top: 0; margin: 0 auto;
}

.section1_space{
  width: 1280px; height: 400px;
}

.section1_pv{


  right: 0; left: 0%; top: 0; bottom: 0; margin: 0 auto;

}
</style>