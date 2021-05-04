import React from 'react';
import axios from 'axios';

class CallApi extends React.Component{

    state = {
        jsons: []
    }

    componentDidMount(){
        axios.get(`http://localhost:8088/start/json`).then(res => {
            const jsons = res.data;
            this.setState({jsons});
        });
    }

    render() {
        console.log('Start calling endpoint');
        return(
        <ul>
            <h1>Data</h1>
        {this.state.jsons.map(json => <li>{json.id} : {json.name} : {json.profession} : {json.address} : {json.isEnabled}</li>)}
        </ul>
        )
    }

};

export default CallApi;