import { useEffect, useState } from "react";
import './Admin.css'
import axios from "axios";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
let val=0

export default function AddDeleteTableRows(){
    const [rowsData, setRowsData] = useState([])
    const [state,setState] = useState('')
    const modalShow=true;

    function getData()
    {
      axios.get('http://localhost:8080/api/excel/getconfig')
      .then((data) => {
        setRowsData(data.data)
        console.log(rowsData)
      } 
      )
      .catch((error)=>{
        console.log(error)
      })
    }
    useEffect(()=>{
      getData()
    },[])
    function saveToDo()
    {
      let rowData=[]
      rowsData.map((data)=>{
        if(data.configvalue!==null && data.configvalue.trim()!==''){
          let obj={
                    configkey:`${data.configkey}`,
                    configvalue:`${data.configvalue}`        
                  }
          rowData.push(obj)
        }
        else{
          let obj={
            configkey:`${data.configkey}`,
            configvalue: "No data available"        
          }
          rowData.push(obj)
        }
      })
      console.log(rowData)
    axios.post('http://localhost:8080/api/excel/configdata',rowData)
    .then(response => {
        val=1
        setState(response.data)
        console.log(response.data)
      })
      .catch((error)=>{
        setState(error.response.data)
        console.log(error.response.data)
      })
    }
    
    const handleChange = (index, evnt)=>{
        const rowsInput = [...rowsData];
        rowsInput[index].configvalue = evnt.target.value
        setRowsData(rowsInput);
    }

    return(
        <div className="container" id="addtable">
          <div id="config-data"><h1 id="config">CONFIG DATA</h1></div>
          <div id="right-container">
            <div className="row">
                <div className="col-sm-9">
                    <table className="table" id="table-rows">
                        <thead>
                        <tr >
                          <th className="property">PROPERTY NAME</th>
                          <th className="property">PROPERTY VALUE</th>
                      </tr>
                    </thead>
                   <tbody>
                      {rowsData.map((data, index) => {
                         const data1 = data.configkey
                         const data2 = data.configvalue
                        return( <tr key={index} id='tr'>
                          <td className="td"><label type="text" id='tr1'  onChange={(evnt)=>(handleChange(index, evnt))} name="configkey" >{data1}</label></td>
                          <td className="td"><input type="text" id='tr2' value={data2} onChange={(evnt)=>(handleChange(index, evnt))} name="configvalue"/> </td>
                          </tr>
                          )
                      })}
                   </tbody> 
                </table>
                </div>
            </div>
            <div id="save-btn"><button id="save" onClick={saveToDo}>SAVE</button></div>
            {state && <MyVerticallyCenteredModal show={modalShow} value={val} name={state}  onHide={() => {
              setState(false)
              if(val){
                window.location.reload()
              }
            }}/>}
          </div>
        </div>
    )
}

function MyVerticallyCenteredModal(props) {
  return (
    <Modal
      {...props}
      size="sg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
        <span id='title-msg'>{props.value ? "Message" : "Error"}</span>&nbsp;
          {props.value ? <span id='message'>&#x2713;</span> : <span id='warning'>&#x26A0;</span>}              
      </Modal.Title>
      </Modal.Header>
      <Modal.Body>
         <p id='info'>{props.name}</p>
      </Modal.Body>
      <Modal.Footer>
        <Button onClick={props.onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
}
 