<template>

    <v-card outlined>
        <v-card-title>
            CheckStock # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="ProductId" v-model="item.productId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProductName" v-model="item.productName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OrderId" v-model="item.orderId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'CheckStockViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/checkStocks/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

