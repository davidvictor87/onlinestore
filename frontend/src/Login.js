import { Form } from "react-bootstrap";
import { Card, Row } from "react-bootstrap";
import React, {Component} from 'react';
import {Col, Button, ButtonToolbar, Container} from "react-bootstrap"

class Login extends React.Component{

    constructor(props, context){
        super(props, context);
        this.state = {
            user: '', 
            password: '',
            hasLoginFailes: false, 
            showSuccessMessage: false
        };
        this.onChange = this.onChange.bind(this);
    }

    onChange(e){
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    render(){
        return(
            
              <diV className="content">
                  <Container>
                     <Row>
                         <Col md={{ span: 4, offset: 4}} className= "text-center">
                             <Card border="dark">
                                 <Card.Header as="h3" className="text-center">
                                     Login
                                 </Card.Header>
                                 <Card.Body>
                                     <Form id="login-form" action="/start/login" method="GET">
                                        <Form.Group controlId="formUserName">
                                          <Form.Control type="text" name="user" onChange={this.onChange} placeholder="Username"/> 
                                        </Form.Group>
                                        <Form.Group controlId="formPassword">
                                                <Form.Control type="password" name="password" onChange={this.onChange} placeholder="Password" />
                                            </Form.Group>
                                            <ButtonToolbar size="lg">
                                                <Button type="submit" variant="dark" block> Submit </Button>
                                            </ButtonToolbar>
                                     </Form>
                                 </Card.Body>
                             </Card>
                         </Col>
                     </Row>
                  </Container>
                </diV>
        );
    }

}

export default Login;