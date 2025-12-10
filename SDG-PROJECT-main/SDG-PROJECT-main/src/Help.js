import './Admin.css'
import data from './MasterDataColumnNames.json'

export default function Help() {
    let count=1
    return (
        <div>
            <div id='help-div'>
            {
                data.map((ele) => {
                    return (
                        <table id='table'>
                            <tr><td className='h3-class' colSpan='3'>Goal{count++}</td></tr>
                            <tr className='th-class'>
                                <th>S.No</th>
                                <th>Column Name</th>
                                <th>Cell Format</th>
                            </tr>
                            {
                                ele.map((element) => {
                                    return (
                                        <tr className='tr-class'>
                                            <td>{element.sno}</td>
                                            <td>{element.columnName}</td>
                                            <td>{element.cellFormat}</td>
                                        </tr>)
                                })
                            }
                        </table>)
                })
            }
            </div>
        </div>
    )
}