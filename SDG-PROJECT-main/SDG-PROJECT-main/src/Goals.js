import { useEffect, useState } from "react";
import * as d3 from 'd3';
import './css/style.css';
import React from "react";
import Button from './Button.js';
import Menu from './Menu.js';
let count = 0;

export default function Goals(props) {
  
  const [val, setValue] = useState(props.data? [props.data[0],props.data[1],props.data[2]] : [1,"50px","60px"])
  const div = document.getElementsByClassName("rotating-logos")
  let colors = ["#eb1c2d", "#d3a029", "#279b48", "#c31f33", "#ef402b", "#00aed9", "#fdb713", "#8f1838", "#f36d25", "#e11484", "#f99d26", "#cf8d2a", "#48773e", "#007dbc", "#3eb049", "#02558b", "#183668"];
  let goals = ["GOAL 1", "GOAL 2", "GOAL 3", "GOAL 4", "GOAL 5", "GOAL 6", "GOAL 7", "GOAL 8", "GOAL 9", "GOAL 10", "GOAL 11", "GOAL 12", "GOAL 13", "GOAL 14", "GOAL 15", "GOAL 16", "GOAL 17"];
  let data = ["SDG 1: No Poverty", "SDG 2: Zero Hunger", "SDG 3: Good Health", "SDG 4: Quality Education", "SDG 5: Gender Equality", "SDG 6: Clean Water and Sanitation", "SDG 7: Renewable Energy", "SDG 8: Good Jobs and Economic Growth", "SDG 9: Industry, Innovation and Infrastructure", "SDG 10: Reduced Inequalities", "SDG 11: Sustainable Cities and Communities", "SDG 12: Responsible Consumption", "SDG 13: Climate Action", "SDG 14: Life Below Water", "SDG 15: Life On Land", "SDG 16: Peace and Justice", "SDG 17: Partnership For The Goals"];
  let images = [
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEitHgh-dNmdEtbpa1cqoSY2EA2xcyASr6VAFJZ_T3Ektuy109kdlynLs_oqS14L7pBhqam-kVHL1gmmwsWBffM73cveh8xsQveKpYuC1lkbsdY5ulcNd-YW0_k2VUX6PfZaYFbQqL8g1ykRa5gXbc29rapBmWyxjDTxNEXRZ_5gNojwnZXGi-Ohs1oG/s1600/1.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjWbFG-m6qLEnGMTK6MeiAIwBQo-pYfG5vGtYjXMaIoRHdyXIrKsGNVqtEHzXXmzQew6XOvznmg_bGkPd3ORFio6QPeqWePwC1oSVf4Da6gCRXB2xr7XQh_8td1onkPnQ_w23KhGijNA4wXjIf9WurVGlBg54nZe1r4rnfa8AOdqZqK_C0bxhaZIWSp/s1600/2.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgF4fDp-hVsmLPmTnRF5ugskrQS_bob_4TUBHJ1HwXzo5U-el_JuBxWEhiMsp8d6sWknYNG495StKsGx6Req0YwzGUI2gi7FnWL9hr6o4uIh7nqx5OQQqd5E0sHUUsBMTThkQmN-z84m1ZkMVp5X0QhIdYIZHfwjY8jmWPCAleweW5G3XeIE_iLQaJB/s1600/3.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiqxmyAsJwmZs48S7Op7Ek9VCfv4Tab4cjaspFW3I08ZK2_vdluu7uh0u7_zzD_8m2VCj-QmaaTmiDbOSchGjJ2us4c71wfRnqSAE4pSskpnvD04Q8cj1TCeiOVpyAV_LyNFF_4dxz38M3GQetfXgMYy0OWfWnE41xJ4-lkbRWPh3fXnu3lLsivxzcj/s1600/4.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgVY0PHdolMVCIwEilVRADOVNUI829dmg1x3IextQ25uqBY7kT0kvvevVD_uD3tT4qUW5sUEmqBkn_F9k0TtwuIP_TEEXLEdiocoQiNptrmdGWtu71s0f-8-2ZHLiO_Oo3rHtdDUwg1mv8oPUQupOSsvx8VINVVRCq3KsaCfV-mrnAkiLGy3zsDueuk/s1600/5.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg3XweoTLf_MOR2xw5iN1eQsZtP3H5SAS2m4OE__kpyYRh5cYrW444xs1EdJQgAwJQhhxgJP0WWXrwRQ71lEejimT_2Yh1kg7v47lglCK87ypuhneTuampQ434H8bfxX4zNfoUJLxGpVGTMPP8xUWxcWqzPV1NJjRW1aOeMmcfFNVyI-uFBG0_ySr6S/s1600/6.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiqxtMLiFcb0EpT-K6ntZc-JMR1yIALfz6BZU8gXWrP_xHZn06pILG2WtWIL9B_poMwD4RYHvPeUdhWvLLHTM0Qlo_5qbl8v3Ckt4MQI7lGryjYcDZcLGguNBZu_DHHrDdqh2FQDgf1PRnmR_zuAIFBKkjwJSVhbaWUlM7YunMo3KoHU9aozrAldhQ0/s1600/7.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi9DdcAVjQMAJv9FYI0RfuVxp8l8tqS8KxTnJ-zJmUI-aUJtWKLBrocxfSjNryEVs7uVmQhym8-3pRMYzOoZzDYPUtQmeoM7dDxcTgWITCYdj5o3yfgvOx97_ydRVLmBmO37YVaplWcEsAYalAJk7L6c-xblUB1s9NFSJi2sEFk9LDCNkCIN4qWsZp_/s1600/8.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj8s2HOrX4m3xoBWZRdSlQ2Yx46LDzey4Gku4NqbUNaNUFjfkmJY0BcqGhl5kdzwOntlGhLiku31dni9K2TGqsN0wwevDQwKoBW0ulDjPPhY2wrHXBbvbD4CZQmYa2Uf5Abq1cGwvyei18J8vLV8Rgx6Nt95eGh-6TKpBdCsmP6x6FBOk_knPjX0a8L/s1600/9.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi6ng411QUou_8yuqER_iXaX3JsSjgF4Gm1OZKTwgVV0YnPY92YD6F4qeuHy13qjRZliBLW9TDUdAAojETuFcxK8649yWUQPs9NTFTYSRcUggUQ_BjzOC06aKm4foqdTfe4W9qaxf74jUBpHh-KDONXYJTrjTErvySRlfnrjgQ91khrCtyxWFB_lb5m/s1600/10.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi9GiVgWjvn5QLiHJ9XvfUxnvtzWDCARWLYs7MnS9gXhuaLQhz3qSvQ2YA9dJ8P7OW8i8_3ZQt6T5JCdmcrAmkwlhBKceRazrir3ne_F3lQm5KRfBh_w-GF-hQrlL85Wchen3T_TwyP-Chm2YlDIexRrYhSNkHJD1On-5IUnnySbNcuJoPWBpDCOpP0/s1600/11.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgZnliF3xB1mMo8vkojhS7SVrWqkfGMCfCvGXSC5yAjrGAgs5SiF9v4-dkHTsL1vSMWt2FsxGAsPqMshOoF-PEEnqZVqJM8oDFhroIt6cuzr5prRCs8hVKRUCLCDORqdjQP7C6FAjf8rRG4v4zVf5yyUbXmxD1iF2G_odV1mSK7QF9BQxNpZ0piMDOJ/s1600/12.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgOPuMVvMaoIsrjIqxzUV9hbDCmNsT0hE2DcbrS6NKUl7Ma3DcTEXlHJn6XRvwfsHFrIjgg0eqFem_L2IhCgQtYs1dmnJ8oUr8o3XppRHTu-5RY9KN4r47kvhCmrbObH-8FQAqIPSOt6bZ3xF_FdHk2zhPaPGGch-8UgFmjvfQO9rWaLDAoVliJi9yZ/s1600/13.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh97iygmXxNpTSvQSPZ1tTZUa7_s6gtKhc1f-TMJg_tNHHQyV1sTLdTzylrpHtp6JWcoXhVrxdm2p-Jdqyr3Ri2jftjWOq9aY8c2GSma0EUfDfx765DyYRg0rNScsfjSqxKKig-WHfmKU7xET8zIgDoVoPJRo1w69ul_PfPabIOY0vEuwzRBCenZFpW/s1600/14.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEil5m10P4h7A7aZL00UKjKeZEc4TEaLC_DyFDeTNqyvz0F0mYmCwJy1NCnHnXlI2BlAWYHBDwMCj3tHjfdZ2ntvbgm_gfgU5tphYTh33Ja7qU0hdcSpTmtmN7ctqGocf0d28brk5TCYziogX1hl5VMt3ai4e8eochGdMymdIfkv2U5vp769K9SWHOW4/s1600/15.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEircrRzjnLHVV1xojGArnUbjROvQ9b4c3bqXgW5LiGtaD6zu57CYb8BAxdddyyEqnTIapaNxrzlYrAgrVSdsvwH7rfbXmGDpuFudLMs32shqPQbYWdUTL4yA09pmedl2u0GTN4r5L2ha1RqPXI5N1LGygrHlYGHlB-NZjyJiZbuhEzZF67VjrXNat3r/s1600/16.png",
    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjvd7vJny3vPyPyHpo37f13tFgA2wLrcXyDCxMzrSeGiKY7XTorKDjo0qo1ZFVnRWW2OREryyrUGmedgl_h2orDWVOxDpkcvCwcWQGrEpMM0xz3rPOe2SiFg-8IiYrNv18xMbXDCyQoknakejOheY_fgGeL9YALA3swfyCZK39-nOsB0HXwbigPEZt3/s1600/17.png"]

    function getData(val) {
    let treeData = [];
    fetch(`http://localhost:8080/api/excel/treegoals/${val[0]}`)
      .then(response => response.json())
      .then((data) => {
        localStorage.setItem('val', JSON.stringify(val))
        treeData.push(data);
        if (count != 0) {
          removeElement();
        }
        count++;
        setData(treeData, val[0]);
        for (const divs of div){
          divs.style.display="none"
        } 
      });
    }

  function removeElement() {
    document.getElementsByTagName("svg")[0].remove();
    document.querySelector(".tool").remove();
  }

function removeDiv()
{
  for(const divs of div){
   divs.style.display = "block";
  }
}

  useEffect(()=>{
    removeDiv()
    getData(val)
  },val)
 
  function button1() {
    setValue([1,"50px","60px"])
  }
  function button2() {
    setValue([2,"50px","60px"])
    }
  function button3() {
    setValue([3,"50px","60px"])
    }
  function button4() {
    setValue([4,"50px","60px"])
   }
  function button5() {
    setValue([5,"60px","50px"])
  }
  function button6() {
   setValue([6,"70px","60px"])
  }
  function button7() {
    setValue([7,"50px","60px"])
  }
  function button8() {
    setValue([8,"60px","60px"])
  }
  function button9() {
    setValue([9,"60px","60px"])
  }
  function button10() {
    setValue([10,"60px","60px"])
  }
  function button11() {
    setValue([11,"50px","60px"])
  }
  function button12() {
    setValue([12,"45px","80px"])
  }
  function button13() {
    setValue([13,"40px","80px"])
  }
  function button14() {
    setValue([14,"50px","60px"])
  }
  function button15() {
    setValue([15,"50px","50px"])
  }
  function button16() {
    setValue([16,"50px","50px"])
  }
  function button17() {
    setValue([17,"50px","50px"])
  }

  function setData(treeData, val) {
    if(treeData.length>0){
      
      const imageTop = document.getElementById('imagetop')
      const textTop = document.getElementById('texttop')
      const image = document.getElementById('img')
      
      image.src = images[val - 1];
      imageTop.innerHTML = goals[val - 1];
      textTop.innerHTML = data[val - 1];
      textTop.style.color = colors[val - 1];
      imageTop.style.color = colors[val - 1];
      imageTop.style.fontSize = "2rem";
      imageTop.style.marginBottom = "0";
      imageTop.style.fontWeight = "bolder";
      textTop.style.marginTop = "0";

      // var margin = { top: 45, right: 0, bottom: 0, left: 225 },
      // width = 1450 - margin.right - margin.left,
      // height = 715 - margin.top - margin.bottom;
      
      var margin = {
        top:(325 / window.innerHeight) * 100,
        right: 0,
        bottom: (250 / window.innerWidth) * 100,
        left:(3000 / window.innerWidth) * 100
      };
      
      var width = window.innerWidth-margin.left-margin.right
      var height = window.innerHeight-margin.top-margin.bottom

     var i = 0,
      duration = 750,
      root;

      var tree = d3.layout.tree().size([height, width]);

      var diagonal = d3.svg.diagonal().projection(function (d) {
      return [d.y, d.x];
      });

    var svg = d3
      .select("#test")
      .append("svg")
      .attr("width", width + margin.right + margin.left)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    var div = d3
      .select("body")
      .append("div")
      .attr("class", "tool")
      .style("opacity", 1e-6);

    root = treeData[0];
    root.x0 = height / 2;
    root.y0 = 0;

    update(root);

    d3.select(window.self.frameElement).style("height", "500px");

    function update(source) {

      // Compute the new tree layout.
      var nodes = tree.nodes(root).reverse(),
        links = tree.links(nodes);

      // Adjust y position based on node depth
      nodes.forEach(function (d) {
        if (d.depth === 1) {
          d.y = d.depth * 180;
        } else if (d.depth === 2) {
          d.y = d.depth * 350;
        } else if (d.depth === 3) {
          d.y = d.depth * 270;
        } else if (d.depth === 4) {
          d.y = d.depth * 180;
        } else {
          d.y = d.depth * 100;
        }
      });

      const node = svg.selectAll('g.node').data(nodes, function (d) {
        return d.id || (d.id = ++i);
      });

      // Enter any new nodes at the parent's previous position.
      var nodeEnter = node
        .enter()
        .append("g")
        .attr("class", "node")
        .attr("transform", function (d) {
          return "translate(" + source.y0 + "," + source.x0 + ")";
        })
        .on("click", click);

      nodeEnter
        .append("circle")
        .attr("r", 1e-6)
        .on("mouseover", () => {
          div.transition().duration(300).style("opacity", 1);
        })
        .on("mousemove", (d) => {
          div
            .text(`${d.display}`)
            .style("left", `${d3.event.pageX}px`)
            .style("top", `${d3.event.pageY}px`)
            .attr("class", "tool");
        })
        .on("mouseout", () => {
          div.transition().duration(300).style("opacity", 1e-6);
        })
        .style("fill", function (d) {
          return d.children ? `${colors[val - 1]}` : `${colors[val - 1]}`;
        });

      nodeEnter
        .append("text")
        .attr("x", function (d) {
          return d.children || d._children ? -20 : +20;
        })
        .attr("dy", ".35em")
        .attr("text-anchor", function (d) {
          return d.children || d._children ? "end" : "start";
        })
        .style("font-size", "0.9rem") // Set the font size to 1.6 rem
        .text(function (d) {
          if (!d.children && !d._children && d.depth >= 3 && d.value) {
            return d.name + " " + d.value;
          }
          return d.name;
        })
        .style("fill-opacity", 1e-6)
        .append("title")
        .text(function (d) {
          return d.display;
        });

      // Transition nodes to their new position.
      var nodeUpdate = node
        .transition()
        .duration(duration)
        .attr("transform", function (d) {
          return "translate(" + d.y + "," + d.x + ")";
        });

      nodeUpdate
        .select("circle")
        .attr("r", 10)
        .style("fill", function (d) {
          return d.children ? `${colors[val - 1]}` : `${colors[val - 1]}`;
        });

      nodeUpdate.select("text").style("fill-opacity", 1);

      // Transition exiting nodes to the parent's new position.
      var nodeExit = node
        .exit()
        .transition()
        .duration(duration)
        .attr("transform", function (d) {
          return "translate(" + source.y + "," + source.x + ")";
        })
        .remove();

      nodeExit.select("circle").attr("r", 1e-6);

      nodeExit.select("text").style("fill-opacity", 1e-6);

      // Update the links…
      var link = svg.selectAll("path.link").data(links, function (d) {
        return d.target.id;
      });

      // Enter any new links at the parent's previous position.
      link
        .enter()
        .insert("path", "g")
        .attr("class", "link")
        .attr("d", function (d) {
          var o = { x: source.x0, y: source.y0 };
          return diagonal({ source: o, target: o });
        });

      // Transition links to their new position.
      link.transition().duration(duration).attr("d", diagonal);

      // Transition exiting nodes to the parent's new position.
      link
        .exit()
        .transition()
        .duration(duration)
        .attr("d", function (d) {
          var o = { x: source.x, y: source.y };
          return diagonal({ source: o, target: o });
        })
        .remove();

      // Stash the old positions for transition.
      nodes.forEach(function (d) {
        d.x0 = d.x;
        d.y0 = d.y;
      });
    }

    // Toggle children on click.
    function click(d) {
      if (d.children) {
        d._children = d.children;
        d.children = null;
      } else {
        d.children = d._children;
        d._children = null;
      }
      update(d);
    }
  }
  }
  const commonStyle = {
    padding: '0%',
    border: '0',
    margin: '0%',
  }
  return (
    <div className="goals-main">
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
      <div id="test"></div>
      <div id="logo1">
        <img width={val[2]} height={val[1]} alt="SDG" id="img" />
        <div id="logo2">
          <h1 id="imagetop"></h1>
          <p id="texttop"></p>
        </div>
      </div>
      <div className="rotating-logos">
      <img src="./SDGlogo.png" width="125rem" id="rotate-logo" height="125rem" alt="SDG"/>
    </div>
    </div>
  )
}