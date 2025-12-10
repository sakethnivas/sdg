import './Admin.css';
import { useState } from "react";
import axios from "axios";
import AdminPage from './AdminPage';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

let mode = 0

export default function Admin() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [user, setState] = useState(() => {
    let val = localStorage.getItem('value')
    let vals = val ? true : false
    return vals
  })
  const [modal, setModal] = useState("")
  const [modalShow, setModalShow] = useState(true);

  function setModalData() {
    setModalShow(false);
    setModal(false)
    window.location.reload();
    if (mode) {
      setState(true)
    }
  }

  const handleLogin = async (e) => {
    e.preventDefault();
    console.log(username, password)
    axios.post("http://localhost:8080/api/excel/login", { username, password })
      .then(respond => {
        localStorage.setItem('value', JSON.stringify(true))
        mode = 1
        console.log(respond)
        setModal(respond.data)
      })
      .catch(error => {
        setModal(error.response.data)
      });
  };

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
          <p id='info'>{props.name.charAt(0).toUpperCase() + props.name.slice(1)}</p>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={setModalData}>Close</Button>
        </Modal.Footer>
      </Modal>)
  }

  return (
    <div>
      {user ? <AdminPage /> :
        <div id='login-form'>
          <div id="loginform">
            <h2 id="headerTitle">Login</h2>
            <form onSubmit={handleLogin} id='forms'>
              <div class="row">
                <label className='label-row'>Username</label>
                <input type="text" placeholder="Enter your username" value={username} onChange={(e) => setUsername(e.target.value)} role="administrator" />
              </div>
              <div class="row">
                <label className='label-row'>Password</label>
                <input type="password" placeholder="Enter your password" value={password} onChange={(e) => setPassword(e.target.value)} />
              </div>
              <div id="button-div" class="row">
                <button id='button-row' onClick={handleLogin}>Login</button>
              </div>
            </form>
            {modal && <MyVerticallyCenteredModal show={modalShow} name={modal} value={mode} onHide={() => setModalShow(false)} />}
          </div>
        </div>}
    </div>
  )
}
