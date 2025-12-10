import React from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Goals from './Goals.js';
import Home from './Home.js';
import SideMenuBar from './SideMenuBar.js';
import Admin from './Admin.js';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

export default function App(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Home/>} />
                <Route path='/dashboard' element={<Goals/>} />
                <Route path='/goals' element={<SideMenuBar/>}/>
                <Route path='/admin' element={<Admin/>}/>
            </Routes>
        </BrowserRouter>
    )
}

