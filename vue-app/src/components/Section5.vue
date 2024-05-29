<template>
  <div class="section s5">

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
</template>

<script>


export default {
  name: 'Section5',

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