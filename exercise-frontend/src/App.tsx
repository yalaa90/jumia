import React, { useState } from 'react';
import logo from './logo.png';
import './App.css';
import DataTable from 'react-data-table-component';
import Select from 'react-select'
import { countries } from './model';
import { getCustomers } from './service';

const columns = [

  {
    name: 'Country',
    selector: (row: any) => row.country,
    sortable: true,
  },
  {
    name: 'State',
    selector: (row: any) => row.valid ? "Valid" : "Not Valid",
    sortable: true,
  },
  {
    name: 'Code',
    selector: (row: any) => row.code,
    sortable: true,
  },
  {
    name: 'Phone Number',
    selector: (row: any) => row.phone,
    sortable: true,
  },
];





function App() {
  let [countryFilter, setCountryFilter] = useState("",)
  let [stateFilter, setStateFilter] = useState("",)
  let [data, setData] = useState([],)
  let [totalRows, setTotalRows] = useState(0,)

  return (
    <div className="container">
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href=" #">

          <img src={logo} className="navbar-brand App-logo" alt="logo" />
        </a>
        <ul className="navbar-nav mr-auto">
          <li className="nav-item active">
            <a className="nav-link" href=" #"  >Home </a>

          </li>
        </ul>
      </nav>

      <section className="search-sec mt-3">
        <div className="container">
          <form action="#" method="post"  >
            <div className="row">
              <div className="col-lg-12">
                <div className="row">
                  <div className="col-sm-3"></div>
                  <div className="col-lg-2 col-md-3 col-sm-12 p-0">

                    <Select options={countries} isSearchable onChange={(value) => setCountryFilter(value?.value || '')} />

                  </div>


                  <div className="col-sm-1"></div>

                  <div className="col-lg-2 col-md-3 col-sm-12 p-0">
                    <select className="form-select" id="exampleFormControlSelect1" onChange={(value) => setStateFilter(value.target.value)}>
                      <option value=""></option>
                      <option value="valid">Valid</option>
                      <option value="notValid">Not Valid</option>

                    </select>
                  </div>

                  <div className="col-sm-1"></div>
                  <div className="col-lg-2 col-md-3 col-sm-12 p-0">
                    <button type="button" className="btn btn-danger wrn-btn" onClick={onClick}>Search</button>
                  </div>

                </div>
              </div>
            </div>
          </form>
        </div>
      </section>

      <section>
        <DataTable
          columns={columns}
          data={data}
          pagination
          paginationTotalRows={totalRows}
          paginationRowsPerPageOptions={[10]}
          paginationServer
          onChangePage={(page: number, totalRows: number) => {
            console.log(page + ' / ' + totalRows);
            if (totalRows > 10 && page * 10 <= totalRows)
              getCustomers(page, 10, countryFilter, stateFilter).then((value) => {
                setData((value as any).customerDtoList);
                if ((value as any).totalNum <= totalRows)
                  setTotalRows((value as any).totalNum);

              })
          }}
        />
      </section>
    </div>
  );

  function onClick() {
    getCustomers(0, 10, countryFilter, stateFilter).then((value) => {
      setTotalRows((value as any).totalNum);
      setData((value as any).customerDtoList);
    })
  }
}

export default App;
