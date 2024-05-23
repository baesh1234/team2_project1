<template>
  <div class="section s5" pageNum="5">


    <div class="section5_wrapper">
      <div class="section5_arona"></div>
      <div class="section5_plana"></div>

      <div class="section5_header">
        <div class="secstion5_top">
          <h1>SNS 공유 이벤트</h1>
          <h3>블루 아카이브 소식을 공유하고 선물도 받자!</h3>
        </div>
      </div>


      <div class="secstion5_explain">
        <div class="secstion5_board">
          <br><br><br>
          100주년 맞이 SNS 공유 이벤트를 개최합니다!<br><br>
          1.아래 3가지 SNS를 들어가서 100주년 이벤트를 공유해주세요!<br><br>
          2.공유 게시글에 응원 메세지와 유저 id를 남겨주세요!<br><br>
          3.이벤트 기간동안에 공유해주신 유저분들을 대상으로 푸짐한 <br>보상을 드립니다!
        </div>


      </div>

      <div class="secstion5_social">
        <div class="secstion5_imoticon1"><img src="../assets/images/물루.gif" alt="" width="80px" height="80px"></div>
        <div class="secstion5_sns1" ><img src="../assets/images/instagram.png" alt="" width="60px" height="60px" style="border: 4px solid yellow" no-repeat>instagram<br>&nbsp;</div>
        <div class="secstion5_sns2" ><img src="../assets/images/xlogo.png" alt="" width="60px" height="60px" style="border: 4px solid yellow" no-repeat><br>x<br>(前 트위터)</div>
        <div class="secstion5_sns3" ><img src="../assets/images/blueachive.png" alt="" width="60px" height="60px" style="border: 4px solid yellow" no-repeat><br>블루아카<br> 커뮤니티</div>
        <div class="secstion5_imoticon2"><img src="../assets/images/아루.gif" alt="" width="80px" height="80px"></div>


      </div>




      <div class="secstion5_present">
        <div class="secstion5_gift1">
          <img src="../assets/images/starbuks.jpeg" alt="" width="170px" height="170px"><br>스타벅스 기프티콘<br>100명
        </div>

        <div class="secstion5_gift2">
          <img src="../assets/images/figure.webp" alt="" width="170px" height="170px"><br>아로나 피규어<br>1명
        </div>

        <div class="secstion5_gift3">
          <img src="../assets/images/giftcard.jpg" alt="" width="170px" height="170px"><br>구글기프트카드 10만원<br>10명
        </div>
      </div>

      <div class="section5_back">

      </div>

    </div>

  </div>
</template>

<script>
import axios from "axios";


export default {
  name: 'Section5',




  data() {

  }
}

</script>


<style scoped>


.section5_wrapper{
    position: relative;
    margin: 0 auto;
}

.section5_header{

    display: flex;
    justify-content: center;
    line-height: 20px;

    text-shadow: -1px 0px aqua, 0px 1px aqua, 1px 0px aqua, 0px -1px aqua;
    font-size: 150%;
    font-weight: 300;
}
.secstion5_top{
    margin:0 auto;

    font-family: Arial, Helvetica, sans-serif;
    color: blue;
}



.secstion5_explain{

    display: flex;
    justify-content: center;
}
.secstion5_explain>div{
    width: 720px; height: 480px;

}

.secstion5_board{
    background-image: url(../assets/images/board2.png);
    background-size: cover;
    background-repeat: no-repeat;

    padding-left: 50px;

    /* text-shadow: -1px 0px aqua, 0px 1px aqua, 1px 0px aqua, 0px -1px aqua; */
    font-size: 20px;
    font-weight: 600;
    color: azure;
}

.secstion5_social{

    margin: 10px;
    text-align: center;
    display: block;
    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;

    color: blue;

}
.secstion5_social>div{
    width: 80px; height:80px;
    margin-left: 20px; margin-right: 20px;
    display: inline-block;


}
.secstion5_sns1{

    font-size: 10px;
}

.secstion5_sns2{
    font-size: 10px;
}

.secstion5_sns3{
    font-size: 10px;
}

.secstion5_present{

    text-align: center;

}
.secstion5_present>div{
    background-color: rgb(0,255,255, 0.5);
    margin-left: 10px; margin-right: 10px;

    display: inline-block;
    width: 150px; height: 150px;
}
.secstion5_gift1{
    background-image: url(../assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 15px;
    color: blue;
}
.secstion5_gift2{
    background-image: url(../assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 15px;
    color: blue;
}
.secstion5_gift3{
    background-image: url(../assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 14px;
    color: blue;
}



.section5_arona{
    width: 410px; height: 290px;
    background-image: url("../assets/images/아로나.png");
    background-size: cover;
    background-repeat: no-repeat;
    position: absolute;
    left:0; bottom: 0;
}

.section5_plana{
    width: 410px; height: 290px;
    background-image: url("../assets/images/프라나.png");
    background-size: cover;
    background-repeat: no-repeat;

    position: absolute;
    right: 0; bottom: 0;
}

</style>