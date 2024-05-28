<template>
  <div class="section s1">
    <div class="cherry_blossom" ref="cherryBlossom" id="cherry_blossom">
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
  </div>
</template>

<script>
import $ from 'jquery';


export default {
  name: 'Section1',
  mounted() {
      const defaults = {
        speed: 5,
        maxSize: 15,
        minSize: 10,
        newOn: 400,
      };

      const $wrap = $(this.$refs.cherryBlossom);
      let wrapH = $wrap.height();
      let wrapW = $wrap.width();
      const $petal = $('<span class="petal"></span>');

      const getRandomRotate = () => {
        const rotateX = 360;
        const rotateY = Math.random() * 60 - 30;
        const rotateZ = Math.random() * 120 - 30;
        const translateX = Math.random() * 10 - 5;
        const translateY = Math.random() * 10 - 10;
        const translateZ = Math.random() * 15;
        return `rotateX(${rotateX}deg) rotateY(${rotateY}deg) rotateZ(${rotateZ}deg) translateX(${translateX}px) translateY(${translateY}px) translateZ(${translateZ}px)`;
      };

      const randomSwayAnims = [...Array(10)].map(getRandomRotate);

      const applySwayAnim = (element) => {
        const randomSway = randomSwayAnims[Math.floor(Math.random() * randomSwayAnims.length)];
        element.css('transform', randomSway);
        setTimeout(() => {
          applySwayAnim(element);
        }, 1000);
      };

      const petalGen = () => {
        setTimeout(requestAnimationFrame, defaults.newOn, petalGen);

        const petal = $petal.clone();
        const size = Math.floor(Math.random() * (defaults.maxSize - defaults.minSize + 1)) + defaults.minSize;
        const startPosLeft = Math.random() * wrapW;
        const fallTime = (wrapH * 0.1 + Math.random() * 5) / defaults.speed;
        const horizontalOffset = Math.random() * 2 - 1;

        petal
          .on('animationend', () => {
            petal.remove();
          })
          .css({
            width: size,
            height: size,
            left: startPosLeft,
            position: 'absolute',
            animation: `fall ${fallTime}s linear`,
          })
          .appendTo($wrap);

        const updatePos = () => {
          petal.css('left', `+=${horizontalOffset}`);
          requestAnimationFrame(updatePos);
        };

        updatePos();
        applySwayAnim(petal);
      };

      $(window).resize(() => {
        wrapH = $wrap.height();
        wrapW = $wrap.width();
      });

      requestAnimationFrame(petalGen);
    },


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