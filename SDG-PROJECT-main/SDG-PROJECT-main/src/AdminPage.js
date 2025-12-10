import { useState } from 'react';
import './Admin.css';
import Upload from './Upload';
import AddDeleteTableRows from './AddDeleteTableRows';
import Help from './Help.js'

export default function AdminPage() {
  const [data1, setData1] = useState(getLocalStorage1())
  const [data2, setData2] = useState(getLocalStorage2())
  const [data3, setData3] = useState(getLocalStorage3())
  const styling = {
    fontSize: '1rem',
    paddingTop: '0.8rem'
  }
  function function1() {
    localStorage.setItem('data1', JSON.stringify(true))
    localStorage.setItem('data2', JSON.stringify(false))
    localStorage.setItem('data3', JSON.stringify(false))
    setData1(true)
    setData2(false)
    setData3(false)
  }
  function function2() {
    localStorage.setItem('data1', JSON.stringify(false))
    localStorage.setItem('data2', JSON.stringify(true))
    localStorage.setItem('data3', JSON.stringify(false))
    setData1(false)
    setData2(true)
    setData3(false)
  }
  function function3() {
    localStorage.setItem('data1', JSON.stringify(false))
    localStorage.setItem('data2', JSON.stringify(false))
    localStorage.setItem('data3', JSON.stringify(true))
    setData1(false)
    setData2(false)
    setData3(true)
  }
  function getLocalStorage1() {
    let datas1 = localStorage.getItem('data1')
    if (datas1 === "false") {
      return false
    }
    else {
      return true
    }
  }
  function getLocalStorage2() {
    let datas2 = localStorage.getItem('data2')
    if (datas2 === "true") {
      return true
    }
    else {
      return false
    }
  }
  function getLocalStorage3() {
    let datas3 = localStorage.getItem('data3')
    if (datas3 === "true") {
      return true
    }
    else {
      return false
    }
  }
  function clickHandle() {
    localStorage.removeItem('value')
    localStorage.removeItem('data1')
    localStorage.removeItem('data2')
    localStorage.removeItem('data3')
    window.location.reload();
  }

  return (
    <div id='adminbar'>
      <div id='adminbar1'>
        <div id='adminbar-left'>
          <h4 id='adminbar1-h1'>SDG&nbsp;ADMINISTRATION</h4>
        </div>
        <div id='adminbar-right'>
          <div id='adminbar-right1'>
            <p id='welcome'>WELCOME,&nbsp;</p>
            <p id='to-admin'>ADMIN</p>
          </div>
          <p id='logout' style={styling} onClick={clickHandle}>LOG&nbsp;OUT</p>
        </div>
      </div>
      <div id='adminbar2'>
        <div id='adminbar2-div'>
          <h3 id='msd' onClick={function1}>Master Data</h3>
          <h3 id='cfd' onClick={function2}>Config Data</h3>
          <h3 id='help' onClick={function3}>Help</h3>
        </div>
      </div>
      {data1 && <Upload />}
      {data2 && <AddDeleteTableRows />}
      {data3 && <Help />}
    </div>
  )
}
