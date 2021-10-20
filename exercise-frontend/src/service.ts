import axios, { AxiosResponse } from 'axios';
export async function getCustomers(pageNum: number, pageSize: number, code: string, state: string) {
    console.log("pageNum"+pageNum);

    let response: AxiosResponse = await axios.get("http://localhost:8080/customers", {
        
        params: {
            pageNum: pageNum,
            pageSize: pageSize,
            code: code,
            state: state
        }
    })
    if (response.status === 200) {
        
        return response.data;
    } else {

        alert(response.status + ' Error')
    }

}
