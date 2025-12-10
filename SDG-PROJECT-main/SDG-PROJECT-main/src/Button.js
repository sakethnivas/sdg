import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import Tooltip from 'react-bootstrap/Tooltip';
import './css/style.css'

export default function TooltipPositionedExample(props) {
    
    
    let data = ["SDG 1: No Poverty","SDG 2: Zero Hunger","SDG 3: Good Health","SDG 4: Quality Education","SDG 5: Gender Equality","SDG 6: Clean Water and Sanitation","SDG 7: Renewable Energy","SDG 8: Good Jobs and Economic Growth","SDG 9: Industry, Innovation and Infrastructure","SDG 10: Reduced Inequalities","SDG 11: Sustainable Cities and Communities","SDG 12: Responsible Consumption","SDG 13: Climate Action","SDG 14: Life Below Water","SDG 15: Life On Land","SDG 16: Peace and Justice","SDG 17: Partnership For The Goals"];  
    let image=[
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
    return (
    <>
      {['right'].map((right) => (
        <OverlayTrigger
          key={right}
          placement={right}
          overlay={
            <Tooltip id={`tooltip-${right}`}>
              {data[props.name]}
            </Tooltip>
          }
        >
        {/* <div className='img-outer'> */}
          <div className='img-outer'><img width="100%" className='img-inner' height="100%"  src={image[props.name]}/></div>
          {/* </div> */}
        </OverlayTrigger>
      ))}
    </>
  );
}
