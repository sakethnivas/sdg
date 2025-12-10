import React, { useEffect } from "react";
import Menu from './Menu.js';
import './css/style.css';

export default function Home(){
    return(
        <div className="goals-main">
            <div id="home-outside">
                <img src="./sdgmain.png" className="App-logo" alt=""/>
                <img src="./MP.png" className="mplogo" id="home-h1" alt=""/>
            </div>
            <Menu/>
        </div>
    )
}