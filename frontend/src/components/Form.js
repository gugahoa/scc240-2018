import React from 'react';
import { Field, reduxForm } from 'redux-form';

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
    company_name:{
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
    state:{
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
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
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
        }
    },
    phone1:{
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
        }
    },
    phone2: {
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
        }
    },
    email: {
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
        }
    },
    web: {
        label: 'Last Name',
        field: {
          name: 'lastName',
          placeholder: 'Last Name'
        }
    }
}
const renderFormField = (key, value) => (
  <div>
    <label>First Name</label>
    <div>
      <Field
        name="firstName"
        component="input"
        type="text"
        placeholder="First Name"
      />
    </div>
  </div>
  <div>
)


const FormComponent = (props) => {
  const {
    handleSubmit, pristine, reset, submitting
  } = props;
  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>First Name</label>
        <div>
          <Field
            name="firstName"
            component="input"
            type="text"
            placeholder="First Name"
          />
        </div>
      </div>
      <div>
        <label>Last Name</label>
        <div>
          <Field
            name="lastName"
            component="input"
            type="text"
            placeholder="Last Name"
          />
        </div>
      </div>
      <div>
        <label>Email</label>
        <div>
          <Field
            name="email"
            component="input"
            type="email"
            placeholder="Email"
          />
        </div>
      </div>
      <div>
        <label>Sex</label>
        <div>
          <label>
            <Field
              name="sex"
              component="input"
              type="radio"
              value="male"
            />{' '}
            Male
          </label>
          <label>
            <Field
              name="sex"
              component="input"
              type="radio"
              value="female"
            />{' '}
            Female
          </label>
        </div>
      </div>
      <div>
        <label>Favorite Color</label>
        <div>
          <Field name="favoriteColor" component="select">
            <option />
            <option value="ff0000">Red</option>
            <option value="00ff00">Green</option>
            <option value="0000ff">Blue</option>
          </Field>
        </div>
      </div>
      <div>
        <label htmlFor="employed">Employed</label>
        <div>
          <Field
            name="employed"
            id="employed"
            component="input"
            type="checkbox"
          />
        </div>
      </div>
      <div>
        <label>Notes</label>
        <div>
          <Field name="notes" component="textarea" />
        </div>
      </div>
      <div>
        <button type="submit" disabled={pristine || submitting}>
          Submit
        </button>
        <button type="button" disabled={pristine || submitting} onClick={reset}>
          Clear Values
        </button>
      </div>
    </form>
  );
  };
  
export default reduxForm({
      form: 'CRUD' // a unique identifier for this form
})(FormComponent);
