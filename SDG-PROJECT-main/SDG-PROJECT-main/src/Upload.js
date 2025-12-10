import React, { useState } from 'react';
import axios from 'axios';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faDownload } from '@fortawesome/free-solid-svg-icons'
import './css/style.css';

let mode = 0
export default function Upload() {
  const [file, setFile] = useState(null);
  const [responsemessage, setResponseMessage] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [state, setState] = useState(false)
  const handleFileSelect = (event) => {
    setFile(event.target.files[0]);
  };
  let filetype = 'goals';
  const modalShow = true;

  function MyVerticallyCenteredModal(props) {
    return (
      <Modal {...props} size="sg" aria-labelledby="contained-modal-title-vcenter" centered>
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            <span id='title-msg'>{props.value ? "Message" : "Error"}</span>&nbsp;
            {props.value ? <span id='message'>&#x2713;</span> : <span id='warning'>&#x26A0;</span>}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p id='info'>{props.name ? props.name : "Upload a Master Data Sheet"}</p>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={props.onHide}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
  const handleUpload = () => {
    console.log(file)
    if (file) {
      setIsLoading(true);
      const formData = new FormData();
      formData.append('file', file);
      formData.append('filetype', filetype);
      console.log(formData)
      axios.post('http://localhost:8080/api/excel/upload', formData)
        .then(response => {
          console.log(response);
          setResponseMessage(response.data);
          setIsLoading(false);
          setState(true)
          mode = 1
        })
        .catch(error => {
          console.log(error);
          if (error.response) {
            setResponseMessage(error.response.data);
          }
          else {
            setResponseMessage(error.message)
          }
          setIsLoading(false);
          setState(true)
        });
    }
    else {
      setResponseMessage("Please Upload some Excel File");
      setState(true);
    }
  };
  return (
    <div id='backgnd'>
      <h1 id='upload-h1'>Upload SDG Masterdata Sheet</h1>
      <div id="drop-zone" type="file" onChange={handleFileSelect} style={{ border: "2px dashed #ccc", padding: "0" }}>
        <div id='icon'><FontAwesomeIcon icon={faDownload} bounce size='4x' /></div>
        <input id='choose-file' type="file" onChange={handleFileSelect} />
        or Drop file here
      </div>
      <br /><button id="upload" onClick={handleUpload}>Upload</button>
      {isLoading && (
        <div className="loading">
          <div className="spinner"></div>
        </div>
      )}
      {state && <MyVerticallyCenteredModal show={modalShow} name={responsemessage} value={mode} onHide={() => { setState(false); window.location.reload() }} />}
    </div>
  );
};
