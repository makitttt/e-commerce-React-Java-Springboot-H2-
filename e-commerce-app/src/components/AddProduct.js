import React, { Component, Fragment } from "react";
import withContext from "../withContext";
import { Redirect } from "react-router-dom";
import ProductDataService from '../service/ProductDataService';

const user ='admin';
const initState = {
  name: "",
  price: "",
  stock: "",
  shortDesc: ""
};

class AddProduct extends Component {
  constructor(props) {
    super(props);
    this.state = initState;
    this.save = this.save.bind(this);
  }

  save() {
    let product = {name: this.state.name, price: this.state.price, 
      stock: this.state.stock, shortDesc: this.state.shortDesc
      };
    ProductDataService.createProduct(user,product)
  };

  handleChange = e =>
    this.setState({ [e.target.name]: e.target.value, error: "" });

  render() {
    const { name, price, stock, shortDesc} = this.state;
    const { user } = this.props.context;
    return (
      <Fragment>
        <div className="hero is-primary ">
          <div className="hero-body container">
            <h4 className="title">Login</h4>
          </div>
        </div>
        <br />
        <br />
        <form>
          <div className="columns is-mobile is-centered">
            <div className="column is-one-third">
              <div className="field">
                <label className="label">Product Name: </label>
                <input
                  className="input"
                  type="text"
                  name="name"
                  value={name}
                  onChange={this.handleChange}
                  required
                />
              </div>
              <div className="field">
                <label className="label">Price: </label>
                <input
                  className="input"
                  type="number"
                  name="price"
                  value={price}
                  onChange={this.handleChange}
                  required
                />
              </div>
              <div className="field">
                <label className="label">Available in Stock: </label>
                <input
                  className="input"
                  type="number"
                  name="stock"
                  value={stock}
                  onChange={this.handleChange}
                />
              </div>
              <div className="field">
                <label className="label">Short Description: </label>
                <input
                  className="input"
                  type="text"
                  name="shortDesc"
                  value={shortDesc}
                  onChange={this.handleChange}
                />
              </div>
              {this.state.error && (
                <div className="error">{this.state.error}</div>
              )}
              <div className="field is-clearfix">
                <button
                  className="button is-primary is-outlined is-pulled-right"
                  type="submit"
                  onClick={this.save}
                >
                  Submit
                </button>
              </div>
            </div>
          </div>
        </form>
      </Fragment>
    );
  }
}

export default withContext(AddProduct);
