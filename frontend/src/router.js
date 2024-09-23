
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import PaymentPayManager from "./components/listers/PaymentPayCards"
import PaymentPayDetail from "./components/listers/PaymentPayDetail"

import ProductInventoryManager from "./components/listers/ProductInventoryCards"
import ProductInventoryDetail from "./components/listers/ProductInventoryDetail"

import SaleSaleManager from "./components/listers/SaleSaleCards"
import SaleSaleDetail from "./components/listers/SaleSaleDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/payments/pays',
                name: 'PaymentPayManager',
                component: PaymentPayManager
            },
            {
                path: '/payments/pays/:id',
                name: 'PaymentPayDetail',
                component: PaymentPayDetail
            },

            {
                path: '/products/inventories',
                name: 'ProductInventoryManager',
                component: ProductInventoryManager
            },
            {
                path: '/products/inventories/:id',
                name: 'ProductInventoryDetail',
                component: ProductInventoryDetail
            },

            {
                path: '/sales/sales',
                name: 'SaleSaleManager',
                component: SaleSaleManager
            },
            {
                path: '/sales/sales/:id',
                name: 'SaleSaleDetail',
                component: SaleSaleDetail
            },



    ]
})
