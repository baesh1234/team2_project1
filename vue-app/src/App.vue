<template>
  <div id="fullpage">
    <Section1 class="section"/>
    <Section2 class="section"/>
    <Section3 class="section"/>
    <Section4 class="section"/>
    <Section5 class="section"/>
  </div>
</template>

<script>
import Section2 from "@/components/Section2.vue";
import Section1 from "@/components/Section1.vue";
import Section5 from "@/components/Section5.vue";
import Section4 from "@/components/Section4.vue";
import Section3 from "@/components/Section3.vue";

import Sakura from '@/assets/js/sakura.js';



export default {
  components: {Section1, Section2, Section3, Section4, Section5},
  mounted() {
    new fullpage('#fullpage', {
      sectionSelector: '.section',
      scrollOverflow: true,
      navigation: true,
      scrollingSpeed: 1000,
      anchors: ['section1','section2', 'section3', 'section4', 'section5'],
       afterLoad: (origin, destination, direction) => {
               this.$nextTick(() => {
                 this.initializeSakura(`#section${destination.index + 1}`);
               });
             },
    });
  },

  methods: {
      initializeSakura(selector) {
            const element = document.querySelector(selector);
            if (element) {
              const sakura = new Sakura(selector);
              sakura.start();
            }
          }
    }

};
</script>

<style src="@/assets/css/sakura.css"></style>
<style>
/*All*/
.section { /*배경화면*/
  background-image: url('assets/images/bgImg.jpg');
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
/*fullpage nav 재정의*/

#fp-nav.fp-right {
  right: 5%; /*네비바 오른쪽 여백*/
}
#fp-nav ul li {
  margin: 5rem;
  z-index: 2000;
}
#fp-nav ul li a span {
  background: unset;
}

#fp-nav ul li a {
  width: 4rem; /* 내비게이션 아이템의 너비 설정 */
  height: 4rem; /* 내비게이션 아이템의 높이 설정 */
  background-image: url('https://item.kakaocdn.net/do/4155f71e3350f0ee40ffde6dcdcb2804d0bbab1214a29e381afae56101ded106'); /* 배경 이미지 설정 */
  background-size: cover; /* 배경 이미지를 아이템에 맞게 조정 */
}

#fp-nav ul li a.active {
  width: 4rem; /* 내비게이션 아이템의 너비 설정 */
  height: 4rem; /* 내비게이션 아이템의 높이 설정 */
  background-image: url('https://item.kakaocdn.net/do/4155f71e3350f0ee40ffde6dcdcb2804f604e7b0e6900f9ac53a43965300eb9a'); /* 배경 이미지 설정 */
  background-size: cover; /* 배경 이미지를 아이템에 맞게 조정 */
}
/*벚꽃*/
.cherry_blossom {
    overflow: hidden;
    position: relative;
    width: 100%;
    height: 100%;
    perspective: 1000px;
}
.cherry_blossom .petal {
    position: absolute;
    background: linear-gradient(-45deg, #ffb6c1 0%, #ffc5d0 40%, #ffdfe6 80%);
    border-radius: 10% 50% 40% 50%;
    z-index: 1;
    box-shadow: 0 0 20px rgba(255, 255, 255, 0.8);
    pointer-events: none;
    transform-style: preserve-3d;
    transition: transform 1000ms linear;
}
@keyframes fall {
    0% {
            top: 0;
    opacity: 1;
    }
    80% {
            opacity: 1;
    }
    100% {
            top: 100%;
    opacity: 0.2;
    }
}
</style>
