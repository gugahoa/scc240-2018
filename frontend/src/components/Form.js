import React from 'react';
import { Field, reduxForm } from 'redux-form';

import './form.css';

const dataDescription = {
  first_name: {
    label: 'First Name',
    field: {
      name: 'firstName',
      placeholder: 'First Name'
    }
  },
  last_name: {
    label: 'Last Name',
    field: {
      name: 'lastName',
      placeholder: 'Last Name'
    }
  },
  company_name: {
    label: 'Company Name',
    field: {
      name: 'companyName',
      placeholder: 'Company Name'
    }
  },
  address: {
    label: 'Address',
    field: {
      name: 'address',
      placeholder: 'Address'
    }
  },
  state: {
    label: 'State',
    field: {
      name: 'state',
      placeholder: 'State'
    }
  },
  post: {
    label: 'Post',
    field: {
      name: 'post',
      placeholder: 'Post'
    }
  },
  city: {
    label: 'City',
    field: {
      name: 'city',
      placeholder: 'City'
    }
  },
  phone1: {
    label: 'Phone1',
    field: {
      name: 'phone1',
      placeholder: 'Phone1'
    }
  },
  phone2: {
    label: 'Phone2',
    field: {
      name: 'phone2',
      placeholder: 'Phone2'
    }
  },
  email: {
    label: 'Email',
    field: {
      name: 'email',
      placeholder: 'Email'
    }
  },
  web: {
    label: 'Web',
    field: {
      name: 'web',
      placeholder: 'Web'
    }
  }
};

const renderFormField = (field, index) => (
  <div className="form-field" key={index}>
    <label>{dataDescription[field].label}</label>
    <div>
      <Field
        name={dataDescription[field].field.name}
        component={dataDescription[field].field.component || 'input'}
        type={dataDescription[field].field.type || 'text'}
        placeholder={dataDescription[field].field.placeholder}
      />
    </div>
  </div>
);


const FormComponent = (props) => {
  const {
    handleSubmit, pristine, reset, submitting
  } = props;

  console.log(Object.keys(dataDescription));

  return (
    <div className="form-container">
        <button hidden={false} className="form-btns form-create-btn" type="button">
          Limpar
        </button>
      <div>
        <form onSubmit={handleSubmit}>
          <div className="form">
            {Object.keys(dataDescription).map(renderFormField)}
          </div>
          <div className="form-btns">
            <button className="form-btn" type="submit" disabled={pristine || submitting}>
              OK
            </button>
            <button className="form-btn" type="button" disabled={pristine || submitting} onClick={reset}>
              Limpar
            </button>
          </div>
        </form>
      </div> 
    </div>
  );
};

// TODO: remove reduxForm from here, use only when instantiating
export default reduxForm({
  form: 'CRUD' // a unique identifier for this form
})(FormComponent);
