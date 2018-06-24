import React from 'react';
import ReactTable from 'react-table';

import 'react-table/react-table.css';
import checkboxHOC from 'react-table/lib/hoc/selectTable';

const CheckboxTable = checkboxHOC(ReactTable);

function getColumns(data) {
  const columns = [];
  const sample = data[0];
  Object.keys(sample).forEach((key) => {
    if (key !== '_id') {
      columns.push({
        accessor: key,
        Header: key
      });
    }
  });
  return columns;
}

const rawData = [
  {
    first_name: 'Soledad',
    last_name: 'Mockus',
    company_name: 'Sinclair Machine Products Inc',
    address: '75 Elm Rd #1190',
    state: 'ACT',
    post: 2600,
    city: 'Barton',
    phone1: '02-1291-8182',
    phone2: '0444-126-746',
    email: 'soledad_mockus@yahoo.com',
    web: 'http://www.sinclairmachineproductsinc.com.au'
  },
  {
    first_name: 'Soledad',
    last_name: 'Mockus',
    company_name: 'Sinclair Machine Products Inc',
    address: '75 Elm Rd #1190',
    state: 'ACT',
    post: 2600,
    city: 'Barton',
    phone1: '02-1291-8182',
    phone2: '0444-126-746',
    email: 'soledad_mockus@yahoo.com',
    web: 'http://www.sinclairmachineproductsinc.com.au'
  }
];

function getData() {
  const data = rawData.map((item, key) => ({
    _id: key,
    ...item
  }));
  return data;
}

class TableCompoment extends React.Component {
  constructor(props) {
    super(props);
    const data = getData();
    const columns = getColumns(data);
    this.state = {
      data,
      columns,
      selection: [],
      selectAll: false
    };
    this.toggleSelection = this.toggleSelection.bind(this);
    this.toggleAll = this.toggleAll.bind(this);
    this.isSelected = this.isSelected.bind(this);
    this.logSelection = this.logSelection.bind(this);
    this.handleSelection = this.handleSelection.bind(this);
  }

  handleSelection(sel) {
    console.log({ selected: this.state.data[sel] })
  }


  toggleSelection(key) {
    let selection = [...this.state.selection]; // eslint-disable-line
    const keyIndex = selection.indexOf(key);
    // check to see if the key exists
    if (keyIndex >= 0) {
      // it does exist so we will remove it using destructing
      selection = [
        ...selection.slice(0, keyIndex),
        ...selection.slice(keyIndex + 1)
      ];
    } else {
      // it does not exist so add it
      selection = [key];
    }
    // update the state
    console.log({ selection });
    this.setState({ selection });
    this.handleSelection(selection);
  }

  toggleAll() {
    const selectAll = !this.state.selectAll; // eslint-disable-line
    const selection = [];
    if (selectAll) {
      const wrappedInstance = this.checkboxTable.getWrappedInstance();
      const currentRecords = wrappedInstance.getResolvedState().sortedData;
      currentRecords.forEach((item) => {
        // selection.push(item._original._id); // eslint-disable-line
      });
    }
    this.setState({ selectAll, selection });
  }

  isSelected(key) {
    const { selection } = this.state;
    if (!selection) {
      return false;
    }
    return selection.indexOf(key) >= 0 || false; // eslint-disable-line
  }

  logSelection() {
    console.log('selection:', this.state.selection); // eslint-disable-line
  }

  render() {
    const {
      toggleSelection, toggleAll, isSelected, logSelection
    } = this;
    const { data, columns, selectAll } = this.state;

    const checkboxProps = {
      isSelected,
      toggleSelection,
      toggleAll,
      selectType: 'checkbox',
      getTrProps: (s, r) => {
        const selected = r ? this.isSelected(r.original._id) : false; // eslint-disable-line
        return {
          style: {
            backgroundColor: selected ? 'lightgreen' : 'inherit'
            // color: selected ? 'white' : 'inherit',
          }
        };
      }
    };

    return (
      <div>
        <button onClick={logSelection}>Log Selection</button>
        <CheckboxTable
          ref={r => (this.checkboxTable = r)} // eslint-disable-line
          data={data}
          columns={columns}
          defaultPageSize={10}
          className="-striped -highlight"
          {...checkboxProps}
        />
      </div>
    );
  }
}

export default TableCompoment;
