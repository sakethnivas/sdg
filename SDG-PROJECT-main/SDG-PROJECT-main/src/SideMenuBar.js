import './css/style.css';
import Button from './Button.js';
import Menu from './Menu.js';
import { useEffect, useState } from 'react';
import Goals from './Goals';

export default function SideMenuBar() {
  const div = document.getElementsByClassName("rotating-logos")
  const commonStyle = {
    padding: '0%',
    border: '0',
    margin: '0%',
  }
  const [panelData, setPanelData] = useState([]);
  const [value, setValue] = useState([1, "50px", "60px"]);

  useEffect(() => {
    removeDiv()
    getData(value[0])
    const Div = document.getElementsByClassName('accordion-body');
    for(let divs of Div){
      divs.style.display = "none";
    }
    for(let divs of Div){
      divs.style.display = "block";
      break
    }
  }, value)

  function getData(data) {
    fetch(`http://localhost:8080/api/excel/panelgoals/${data}`)
      .then(response => response.json())
      .then((Data) => {
        setPanelData(Data)
        for (const divs of div) {
          divs.style.display = "none"
        }
      });
  }
  function button1() {
    setValue([1, "50px", "60px"])
  }
  function button2() {
    setValue([2, "50px", "60px"])
  }
  function button3() {
    setValue([3, "50px", "60px"])
  }
  function button4() {
    setValue([4, "50px", "60px"])
  }
  function button5() {
    setValue([5, "60px", "50px"])
  }
  function button6() {
    setValue([6, "70px", "60px"])
  }
  function button7() {
    setValue([7, "50px", "60px"])
  }
  function button8() {
    setValue([8, "60px", "60px"])
  }
  function button9() {
    setValue([9, "60px", "60px"])
  }
  function button10() {
    setValue([10, "60px", "60px"])
  }
  function button11() {
    setValue([11, "50px", "60px"])
  }
  function button12() {
    setValue([12, "45px", "80px"])
  }
  function button13() {
    setValue([13, "40px", "80px"])
  }
  function button14() {
    setValue([14, "50px", "60px"])
  }
  function button15() {
    setValue([15, "50px", "50px"])
  }
  function button16() {
    setValue([16, "50px", "50px"])
  }
  function button17() {
    setValue([17, "50px", "50px"])
  }
  function removeDiv() {
    for (const divs of div) {
      divs.style.display = "block";
    }
  }
  let data1 = ["SDG 1", "SDG 2", "SDG 3", "SDG 4", "SDG 5", "SDG 6", "SDG 7", "SDG 8", "SDG 9", "SDG 10", "SDG 11", "SDG 12", "SDG 13", "SDG 14", "SDG 15", "SDG 16", "SDG 17"];
  let data2 = ["No Poverty", "Zero Hunger", "Good Health", "Quality Education", "Gender Equality", "Clean Water and Sanitation", "Renewable Energy", "Good Jobs and Economic Growth", "Industry, Innovation and Infrastructure", "Reduced Inequalities", "Sustainable Cities and Communities", "Responsible Consumption", "Climate Action", "Life Below Water", "Life On Land", "Peace and Justice", "Partnership For The Goals"]
  let images = [
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjm8K1cUe3cgAo6yKRcNviJ7_cb1qVZWQ1HmOK84z-HwN2XUhtkndJiQ2IurYgJAUguC8bNCDDFAaZ-dxf1VNYOyl5TQA0-MKrJrDLdBIZuZB4lL5lULi6hD-chf-g_2xWYvJHjH1Qic-RaKvfd_7bpiEns37a7PZOnhj1DROArXs_asA49UaqyGfuS/s320/20230324_000346.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhBEuANBQ-fV9p6t77RRJDpmh1k44rZ0aN0E0q0fZ3bDMsu9hJ8-ZGrptFPpYaZovwpfFCNdKRGRTLuTKR4lyClXkQyQuMnbcrb2nM3JY-q6eW2dMK_gqMhmXlwJyjN-LJgewTPTitYTrRwISivsdioY9yo1YgMLLF4Tsn0O7fYQUhQoq2iD0sXGTNT/s320/20230324_001054.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEicI8s0VT6ec8AuJB22ZHTfdqnbyhoZBI2vy8Hni7jdOip994WWrOKczI4Ovx-CaQVWnFz3xc1NvtWO8Aob2lgLV9LamhJ6soSiTNcFMHLJeebt5t2TIzkjKIfWsEy3pI-a7yFdzTqZ62By8YfjOLLYIqeGfnKvPvKdWTYa3A30_8MWs0VaxCpSW6jX/s320/20230324_001320.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgEV_W0kTd6gKjxTiP--uKc97vxV7pEDjaGxGjC7gUMNHGKYzXuGoxh2sirSIm5LWXWI2zrowVpC_btjk9ppZ-nJF8Je241Tnpxfz35nq2MwdOFh1QJ7A78M5j9XGwfgeyzV-epfizzkzm7N6o0DHZJR6vYcyvzTn-aUw121X4nsX3Gh5zXNWCc1MEm/s320/20230324_001601.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEibVj8CI9gXaUrNRikTr9f4v8pvLBTL4lXNZfcTXBBNURt_m9-ykC8pjXeps1IcycvP4TBOLYjMDENt9RSPjnb2SrZRzFilThhaD35VOqwv4KPZQImyp7WIBnpIqCQYT3Xdl4P6XiTt6yqNuapFG9pv4wnmPUYuQ2vRIyroxQR0oPVaz_VJEXeKcilr/s320/20230324_001921.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh8KRvOxVNXJf0DCEnl5P9P6vMhcMbLDSto_cB8WnOaiDC6tIgfO-aU3Q1uhAg2Au_r5KSKT66dM6wTUVQytaGKIyb9-F5M6VRwzaGFtf8lLu7HtEZIy_3k1I47IeRIu_3v9S9x8GAYfpsWoB7EI4_W_l5o3fFoZ3vJa56gkkcn2HRPBt6prr2pF7T-/s320/20230324_002126.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh8AIvdbs2EptX7wpXlWPmbABQy-7Th_FshE8z2QGeHDybjL82BSq-ioZiqsQbgcOhAL9hMJUhnbV55MCRj1X4jiz3as8oCWwCoSyesdp-2ZUqovHZKJjZft75IU4m4052N6dhwWXZfkkxFfRBIxRyLctMpBMa0mCRVQom2rwazNzZFr61dwkPZXwgO/s320/20230324_002414.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhqh8hsNv3Fnodw9ia3qrTljAm1-2G38Xdrw8ZnvstMjGm4iwmkJ0fsVXDoNTHWJ6yqqsJQNtoXb6TrkrjPn2vcgfJSdEsK4X2UHwpK__KEyB4u191ZZ_GiXHaxxTdDrHWn6MDtoos1sjtnmYGPkNKh-oR0igMPk5HUYgLDdEMTfvof4fFuU9Wu9id9/s320/20230324_002613.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhUVluDRGoR2TR6uEBhq0NiVDNoZuKOM1zBhl2lE3OuTZdrrhTgEi3hl620Z15kHIVhf5HVaYqDIuqzV3KLB86RFUTnYJT73B48kvtsyIoNTV1hEITNbZA0nmXHMJZcy-YCDg87SSKHRRfKfpkpxb-aEBX5RM_d52BR-oMvifiXGFpCA87c3vRKEOaH/s320/20230324_002909.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj2HBmR8nOf4-ALqd33QT2dPedetx_C4WAk4nv4aWPchMv1sNOZPL2oB2jMG8YwxoF519rFeoNi_EW4GMLcIL5epkYMteqkJfQzbxK6qClEN9FoweB3ZZJ1WDH1dX0JV4559VEFRczDXSUYGTN9kfxB2V2XgQQ3a-0QvxKXILRhCNV5hcOJ6Gsuuw5P/s320/20230324_003056.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg8BUkgtVHyI5QST8fUKDlVUJyvUFwsun20M9dVK6gxbNxiTVsUR44Ja-fMNNHUWsweOE16bT7cUO0npG67Obq35TYXmS63KkNebb8eCmh4134N1DmuiPyxw_XB9ZpL1zQrMsqO3oZmFq6aGFyAzSYjQQHFpzyvf6NyjOSozqBGd2vB8mQNyVgNWwiU/s320/20230324_090056.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEig6xseiQuwxdee27o-VFAbZSjFkzvlBxLY0ycpgLgyxhjfuLKDh4cS49a2iOjwblzoeKobV1BzPo7uj5bFFJ_pFWTy1GbEPmabEty8EUDQU-PPWv3WY4Fx2-agn-XOqaPA_3kCLBuOW6wwYsSEi-Skx692VBCjc_pq2XxP2UCu9fOx0lyzWYorXgWs/s320/20230324_090456.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhIhCuY-zjMjThBwtAQqVN-un5nAlrHNneLiCmOH7V16lFbjt4TChbnn_ODT5o8HJo66DvMhBmIUFWVWVbQaKL-fu7zFKzFGNhU_p-ZwgECg83NSDPUMHjRYzCI7QCy99Uv9clVu0NzkVFI6lK30PbQYTuyy3U1tyc-PMDVZW7rIpdyVTHVLG-yKXUt/s320/20230324_090918.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiRdQVn58aoETufRstqIqLluK4Xj08_VsyCIExoNd71KPcsvf-7bLEMavDgOCAsrznqVwF-pF7c2sD4xcAd9wOBvVH2EdQqSxnvVEF925Gdz490FxXq3eiNLUR08zMtk34oTdXvOMht3UHKsQaG5lDisufc80a_KDY7cAeVM6S1AN_DIDltMDE2ZShU/s320/20230324_091130.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjSgOsShujbQyDNA8TduPFhcR4R7SofyBP-p3ShOrhFubVQjMR9u50RVIQwvI2U6Fg-qpTDA1oh9ZV35tlP1_6vUxAAP4VHrNEUrxiptgqtwxHKeh_Z8QYCLJeoI0GmrzkwqSLxSf13byNuTKcsdm2fMieZ88z9jh01mPSs8YHkEmxl1HLW_qUmvA6k/s320/20230324_091404.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiQkrf7ZwzPfip-1RfNnykh01hUpbr5Or9LpYR4NPsf8LiBe-ZJu5CUEm1uGKYdu6-8Et_OYFRuSZkmpAN1UBb964fh-2efSq66dqkwQwrvsq4hBqAIsqxBA0WnjGtSKAACpE9xhSpybSdT6IitgRfHflXRQ7v57bdZQ_q6fU68Dni0WvLARiA6QSeY/s320/20230324_091526.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhsXSq6FxCeBt1Z7VX1eOMvOgpvOgyJVtMTqB4jPA1vA6EhDmiueis0eV-_NgPFXD4snUqgkgRDUt0dwLel1C3PH3ahWva6rgGq9JLZELaKzj8EAkVmhF652YLVbutXukj1qj6t_oPYQaiJh6IvvqahU8qlyMHgCMeXhAvuWJEFBNRoV4_QcHvAupkp/s320/20230324_091723.png"
  ]

  let colors = ["#eb1c2d", "#d3a029", "#279b48", "#c31f33", "#ef402b", "#00aed9", "#fdb713", "#8f1838", "#f36d25", "#e11484", "#f99d26", "#cf8d2a", "#48773e", "#007dbc", "#3eb049", "#02558b", "#183668"];
  const comStyle = {
    backgroundColor: colors[value[0] - 1]
  }
  const Div = document.getElementsByClassName('accordion-body');
  const handleClick = (event) => {
    const num = event.target.getAttribute("data-val");
    for (const divs of Div) {
      const nums = divs.getAttribute("data-val")
      console.log(nums)
      if (nums == num) {
          if (divs.style.display == 'none') {
              divs.style.display = "block"
          }
          else {
              divs.style.display = "none"
          }
      }
      else {
          divs.style.display = "none"
      }
  }
  };
  const [val, setVal] = useState(false)
  function clickHandle() {
    setVal(true)
  }

  let sum=1;
  return (
    <div>
      {val ? <Goals data={value} /> :
        <div className='goals-main'>
          <Menu />
          <div className="contain">
            <a style={commonStyle} className="buttons" onClick={button1} data-value="1"><Button name={0} /></a>
            <a style={commonStyle} className="buttons" data-value="2" onClick={button2}><Button name={1} /></a>
            <a style={{ ...commonStyle, backgroundColor: 'white' }} onClick={button3} className="buttons" data-value="3"><Button name={2} /></a>
            <a style={commonStyle} className="buttons" data-value="4" onClick={button4}><Button name={3} /></a>
            <a style={commonStyle} className="buttons" data-value="5" onClick={button5}><Button name={4} /></a>
            <a style={commonStyle} className="buttons" data-value="6" onClick={button6}><Button name={5} /></a>
            <a style={commonStyle} className="buttons" data-value="7" onClick={button7}><Button name={6} /></a>
            <a style={commonStyle} className="buttons" data-value="8" onClick={button8}><Button name={7} /></a>
            <a style={commonStyle} className="buttons" data-value="9" onClick={button9}><Button name={8} /></a>
            <a style={commonStyle} className="buttons" data-value="10" onClick={button10}><Button name={9} /></a>
            <a style={commonStyle} className="buttons" data-value="11" onClick={button11}><Button name={10} /></a>
            <a style={commonStyle} className="buttons" data-value="12" onClick={button12}><Button name={11} /></a>
            <a style={commonStyle} className="buttons" data-value="13" onClick={button13}><Button name={12} /></a>
            <a style={commonStyle} className="buttons" data-value="14" onClick={button14}><Button name={13} /></a>
            <a style={commonStyle} className="buttons" data-value="15" onClick={button15}><Button name={14} /></a>
            <a style={commonStyle} className="buttons" data-value="16" onClick={button16}><Button name={15} /></a>
            <a style={commonStyle} className="buttons" data-value="17" onClick={button17}><Button name={16} /></a>
          </div>
          <img src="logo.png" alt="" width="90px" height="90px" id="logo" />
          <div className="rotating-logos">
            <img src="./SDGlogo.png" width="150rem" id="rotate-logo" height="150rem" alt="SDG" />
          </div>
          {value &&
            <div id='side-container' style={comStyle}>
              <div id="leftside-container" >
                <img width="200rem" height="200rem" id='sdg-logo' src={images[value[0] - 1]} alt='SDG' />
                <h2 className='data'>{data1[value[0] - 1]}</h2>
                <h4 className='data'>{data2[value[0] - 1]}</h4>
              </div>
              <div id="rightside-container">
                <div id='scrollbox'>
                  <div id='scrollbox-inner'>
                    <div className="accordion">
                      { 
                        panelData.map((ele) => {
                        return (
                          <div>
                            <div className="accordion-header" onClick={handleClick} data-val={sum}>
                              <div id="left-accordion" data-val={sum}>
                                <h6 id="h6-accordion" data-val={sum}>{ele.header}</h6>
                                <h4 id="h4-accordion" data-val={sum}>{ele.number}</h4>
                              </div>
                              <div id="accordion-name" data-val={sum}>{ele.name}</div>
                            </div>
                            <div className="accordion-body" data-val={sum++}>
                              <ul>
                                {
                                  ele.children.map((elem) => {
                                    return <li className="accordion-lists" onClick={clickHandle}>{elem.name}</li>
                                  })
                                }
                              </ul>
                            </div>
                          </div>
                        )
                      })}
                    </div>
                  </div>
                </div>
              </div>
            </div>
          }
        </div>
      }
    </div>
  )
}
