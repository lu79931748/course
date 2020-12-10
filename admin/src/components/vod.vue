<template>
  <big-file v-bind:input-id="inputId"
            v-bind:text="text"
            v-bind:suffixs="suffixs"
            v-bind:use="use"
            v-bind:after-upload="afterUpload"
            v-bind:shard-size="1000 * 1024 * 1024"
            v-bind:url="'vod'"></big-file>
</template>
<!--阿里云视频点播不支持追加上传，分片尽量大一些-->

<script>
  import BigFile from "./big-file";
  export default {
    components: {BigFile},
    name: 'vod',
    props: {
      text: {
        default: "上传VOD"
      },
      inputId: {
        default: "vod-upload"
      },
      suffixs: {
        default: []
      },
      use: {
        default: ""
      },
      afterUpload: {
        type: Function,
        default: null
      },
    },
    methods: {
    }
  }
</script>