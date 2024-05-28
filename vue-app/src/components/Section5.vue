<template>
<div class="section s5">
<div class="cherry_blossom" ref="cherryBlossom" id="cherry_blossom">

  <div class="wrapper">
          <div class="board">

              <div class="social">
                  <div class="snsbutton">
                      <div class="sns1" @click='sns1()'></div>
                      <div class="sns2" @click='sns2()'></div>
                      <div class="sns3" @click='sns3()'></div>
                  </div>
                  <div class="community" @click='community()'></div>
              </div>
          </div>

  </div>
  </div>
 </div>
</template>

<script>

import $ from 'jquery';

export default {
  name: 'Section5',

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

  methods: {
        sns1(event){
            window.open('https://www.facebook.com/?locale=ko_KR');
        },

        sns2(event){
            window.open('https://www.instagram.com/');
        },

        sns3(event){
            window.open('https://x.com/?lang=ko');
        },

        community(event){
            window.open('https://forum.nexon.com/bluearchive/main');
        },


   }
}

</script>


<style scoped>


.wrapper{
    margin: 0 auto;
    padding: 0;
    display: flex;
    justify-content: center;


}

.board{
    width: 1209px; height: 932px;
    margin-top: 100px;
    padding: 0px;
    background-image: url(../assets/images/section5_main.png);
    background-repeat: no-repeat;
    background-size: contain;
    position: relative;
    display: inline-block;

}

.social{
    margin: 0 auto;
    display: block;
    position: absolute;
    left: 50%;
    bottom: 30%;

}

.snsbutton{
    width: 300px; height: 90px;
    display: table;
    text-align: center;
    margin-bottom: 5px;
}
.snsbutton > div{
    width: 80px; height: 80px;
    padding: 0;
    display: table-cell;
    vertical-align: middle;
}
.sns1{
    background-image: url(../assets/images/sns_btn1.png);
    background-size: contain;
    background-repeat: no-repeat;
    cursor: pointer;
}

.sns2{
    background-image: url(../assets/images/sns_btn2.png);
    background-size: contain;
    background-repeat: no-repeat;
    cursor: pointer;
}

.sns3{
    background-image: url(../assets/images/sns_btn3.png);
    background-size: contain;
    background-repeat: no-repeat;
    cursor: pointer;
}

.community{
    width: 364px; height: 86px;
    background-image: url(../assets/images/btn1.png);
    background-repeat: no-repeat;
    background-size: contain;
    cursor: pointer;
}

</style>