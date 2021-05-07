import axios from 'axios';
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartDate = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {
    
    let chartDate: ChartDate = { labels: [], series: []};
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then((response) => {
            const data =  response.data as SaleSum[];
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            chartDate = { labels: myLabels, series: mySeries};
            console.log(chartDate);
        })
   // const mockData = {
   //     series: [477138, 499928, 444867, 220426, 473088],
   //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
   // }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart 
            options={{...options, labels: chartDate.labels}}
            series={chartDate.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;