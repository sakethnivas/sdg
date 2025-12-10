import React from 'react';
import './css/style.css';

export default function Menu(){
    return(
        <div id="menu">
        <div id="inside">
            <a id="menus" href='http://localhost:3000'>Home</a>
            <a id="menus" href="http://localhost:3000/dashboard">Dashboard</a>
            <a id='menus' href='http://localhost:3000/goals'>Goals</a>
        </div>
      </div>
    )
}