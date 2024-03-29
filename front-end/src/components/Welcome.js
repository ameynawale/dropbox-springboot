import React, {Component} from 'react';
import {Link,withRouter} from 'react-router-dom';
import PropTypes from 'prop-types';
//import '/App.css';
import * as API from '../api/API';
import ImageGridList from "./ImageGridList";
import '../stylesheets/RightPanel.css';
import TextField from 'material-ui/TextField';
import Typography from 'material-ui/Typography';
import PageHeader from './PageHeader';
import {withStyles} from 'material-ui/styles';
import FileContainer from './FileContainer';
import RightPanel from './RightPanel';
import Starred from './Starred';
import Recent from './Recent';
import '../stylesheets/Welcome.css';
import StarredFiles from './StarredFiles';
import FolderContainer from "./FolderContainer";


const styles = ({
    fileContainer: {
        right: 0,
        paddingLeft: 240,

    }
});

class Welcome extends Component {

    //var styles = ({

    //});

	 /*handleFileUpload = (event) => {

	        const payload = new FormData();

	        payload.append('mypic', event.target.files[0]);
	        payload.append('username',this.state.username);

         API.uploadFile(payload)
             .then((data) => {
                 //   if (status === 201) {
                 API.doGetList(data)
                     .then((res) => this.setState({
                         images: res.file
                     }))
         });

     };*/

    handleFileUser = (userdata) => {
        API.doGetList(userdata)
        // .then((status) => {
        //    if (status === 201) {
        // 	API.getFiles()
            .then((data1) => {
                this.setState({
                    images: data1
                });
            })
    };

    handleFileStar = (userdata) => {
        API.doGetStar(userdata)
        // .then((status) => {
        //    if (status === 201) {
        // 	API.getFiles()
            .then((data2) => {
                this.setState({
                    images_star: data2
                });
            })
    };

    handleCreateFolder = (userdata) => {
        API.doGetFolders(userdata)
        // .then((status) => {
        //    if (status === 201) {
        // 	API.getFiles()
            .then((data2) => {
                this.setState({
                    folders: data2
                });
            })
    };


    /*getUserFiles = (userdata) => {
        API.GetFiles(userdata)
            .then((data) => {
                //console.log(data);
                this.setState({
                    images: data.files
                });
            });
    };*/

    static propTypes = {
        username: PropTypes.string.isRequired
    };

    /*state = {
        username : '',
        	images: []
    };*/

    constructor(props){
        super(props);
        this.state = {
            username : '',
            images: [],
            images_star: [],
            folders: [],
            folderpath : ''
        };

        this.handleFileUser = this.handleFileUser.bind(this);
        this.handleFileStar = this.handleFileStar.bind(this);
        this.handleCreateFolder = this.handleCreateFolder.bind(this);
    }

   componentWillMount(){
        this.setState({
            username : this.props.username,
            //getUserFiles: this.getUserFiles
        });
       this.handleFileUser(this.props);
       this.handleFileStar(this.props);
       this.handleCreateFolder(this.props);

        //document.title = `Welcome, ${this.state.username} !!`;
       //this.getUserFiles(this.state);
    }

    componentDidMount(){
    	
        document.title = `Welcome, ${this.state.username} !!`;
        this.handleFileUser(this.props);
        this.handleFileStar(this.props);
        this.handleCreateFolder(this.props);
       // this.getUserFiles(this.state);
        /*API.getImages()
        .then((data) => {
            console.log(data);
            this.setState({
                images: data
            });
        });*/
       /* API.GetFiles(userdata)
            .then((data) => {
                console.log(data);
                this.setState({
                    images: data
                });
            });*/
    }



    render(){
        return(
            <div>
                <PageHeader/>

                <Starred/>
                <StarredFiles items={this.state.images_star} route={this.props.route} username={this.props.username}/>
                <Recent/>
                <FolderContainer items={this.state.folders} route={this.props.route} username={this.props.username}/>
                <FileContainer items={this.state.images} route={this.props.route} username={this.props.username}/>
                <RightPanel username ={this.state.username} handleFileUpload={this.props.handleFileUpload}/>


            </div>
        )
    }
}

export default withStyles(styles)(Welcome);