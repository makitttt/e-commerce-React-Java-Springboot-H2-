import axios from 'axios'

const PRODUCT_API_URL = 'http://localhost:8080'
const USER_API_URL = `${PRODUCT_API_URL}/products/`

class ProductDataService {

    retrieveAllProducts(name) {
        //console.log('executed service')
        return axios.get(`${USER_API_URL}`);
    }

    retrieveProduct(name, id) {
        //console.log('executed service')
        return axios.get(`${USER_API_URL}/${id}`);
    }

    updateProduct(products) {
        //console.log('executed service')
        return axios.put(`${USER_API_URL}/update`, products);
    }

    createProduct(username, product) {
        console.log('executed service')
        return axios.post(`${USER_API_URL}`, product);
    }
}

export default new ProductDataService()